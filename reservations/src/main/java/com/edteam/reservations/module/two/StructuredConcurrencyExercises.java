package com.edteam.reservations.module.two;

import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.util.DataFakerUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyExercises {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ReservationDTO reservation = DataFakerUtil.generateFakeReservation();

        StructuredConcurrencyExercises exercises = new StructuredConcurrencyExercises();
        System.out.println("Precio final: " + exercises.calcularPrecioFinal(reservation));

        System.out.println("Nombres de pasajeros:" + exercises.obtenerNombresPasajeros(reservation));
        System.out.println("¿Contiene pasajero con nombre Juan: " + exercises.contienePasajero(reservation, "Juan"));
        System.out.println("¿Contiene pasajero con nombre "+ reservation.getPassengers().get(0).getFirstName() + ": " + exercises.contienePasajero(reservation, reservation.getPassengers().get(0).getFirstName()));
    }

    // Ejercicio 1: Obtener nombres de todos los pasajeros en paralelo (fork + join + close)
    public List<String> obtenerNombresPasajeros(ReservationDTO reserva) throws InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            List<StructuredTaskScope.Subtask<String>> tareas = reserva.getPassengers().stream()
                    .map(p -> scope.fork(() -> p.getFirstName() + " " + p.getLastName()))
                    .toList();

            scope.join();
            scope.throwIfFailed();

            return tareas.stream()
                    .map(StructuredTaskScope.Subtask::get)
                    .toList();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    // Ejercicio 4: Obtener precio base y total en paralelo y retornar suma
    public BigDecimal calcularPrecioFinal(ReservationDTO reservation) throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<BigDecimal> base = scope.fork(() -> reservation.getItinerary().getPrice().getBasePrice());
            StructuredTaskScope.Subtask<BigDecimal> total = scope.fork(() -> reservation.getItinerary().getPrice().getTotalPrice());

            scope.join();
            scope.throwIfFailed();

            return base.get().add(total.get());
        }
    }

    // Ejercicio 5: Verificar si hay pasajeros con un nombre específico (shutdownOnSuccess)
    public boolean contienePasajero(ReservationDTO reserva, String nombre) throws InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<Boolean>()) {
            List<StructuredTaskScope.Subtask<Boolean>> tareas = reserva.getPassengers().stream()
                    .map(p -> scope.fork(() -> p.getFirstName().equalsIgnoreCase(nombre)))
                    .toList();

            scope.join();

            return scope.result() != null && scope.result(); // al menos uno encontró coincidencia
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
