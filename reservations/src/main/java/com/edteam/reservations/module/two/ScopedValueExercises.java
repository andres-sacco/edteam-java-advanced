package com.edteam.reservations.module.two;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.util.DataFakerUtil;

import java.util.List;

public class ScopedValueExercises {
    private static final ScopedValue<PassengerDTO> PASAJERO = ScopedValue.newInstance();
    private static final ScopedValue<ReservationDTO> RESERVA = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        ScopedValueExercises exercises = new ScopedValueExercises();
        ReservationDTO reservation = DataFakerUtil.generateFakeReservation();

        System.out.println(exercises.cantidadPasajerosDesdeContexto(reservation));

        System.out.println("-----------------");
        exercises.loggearPasajeros(reservation.getPassengers());

        System.out.println("-----------------");
        System.out.println(exercises.obtenerEmailDeContacto(reservation));
    }

    // Ejercicio 3: Calcular cantidad de pasajeros desde un contexto (get)
    public int cantidadPasajerosDesdeContexto(ReservationDTO reservation) throws Exception {
        return ScopedValue.where(RESERVA, reservation).call(() -> {
            List<PassengerDTO> pasajeros = RESERVA.get().getPassengers();
            return pasajeros != null ? pasajeros.size() : 0;
        });
    }

    // Ejercicio 5: Usar ScopedValue para loggear el nombre del pasajero actual en múltiples threads
    public void loggearPasajeros(List<PassengerDTO> pasajeros) {
        for (PassengerDTO p : pasajeros) {
            ScopedValue.where(PASAJERO, p).run(() ->
                    System.out.println("Procesando: " + PASAJERO.get().getFirstName())
            );
        }
    }

    // Ejercicio 8: Utilizar ScopedValue con un Callable que retorna el email de contacto
    public String obtenerEmailDeContacto(ReservationDTO reservation) throws Exception {
        return ScopedValue.where(RESERVA, reservation).call(() -> RESERVA.get().getPassengers().get(0).getEmail());
    }

}
