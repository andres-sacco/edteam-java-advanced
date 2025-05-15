package com.edteam.reservations.module.two;

import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.util.DataFakerUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExercises {

    // Ejercicio 1: Obtener cantidad de pasajeros (thenApply)
    public CompletableFuture<Integer> obtenerCantidadPasajeros(ReservationDTO reserva) {
        return CompletableFuture.supplyAsync(reserva::getPassengers)
                .thenApply(List::size) ;
    }

    // Ejercicio 6: Imprimir resumen de reserva después del cálculo de precios (thenRun)
    public void imprimirResumenAsync(ReservationDTO reserva) {
        calcularPrecioTotalReserva(reserva)
                .thenAccept(total -> System.out.println("Total: " + total))
                .thenRun(() -> System.out.println("Resumen de reserva impreso!"));
    }

    public CompletableFuture<BigDecimal> calcularPrecioTotalReserva(ReservationDTO reserva) {
        return CompletableFuture.supplyAsync(() -> reserva.getItinerary().getPrice() != null ? reserva.getItinerary().getPrice().getTotalPrice() : BigDecimal.ZERO);
    }

    //Ejercicio 9: Obtener email del contacto o usar valor por defecto (exceptionally)
    public CompletableFuture<String> obtenerEmailConFallback(ReservationDTO reserva) {
        return CompletableFuture.supplyAsync(() -> reserva.getPassengers().get(0).getEmail())
                .exceptionally(e -> {
                    System.err.println("Error al obtener email: " + e.getMessage());
                    return "email@desconocido.com";
                });
    }

}
