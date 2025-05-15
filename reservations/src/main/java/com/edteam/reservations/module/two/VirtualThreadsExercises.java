package com.edteam.reservations.module.two;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.model.SegmentDTO;
import com.edteam.reservations.util.DataFakerUtil;

public class VirtualThreadsExercises {

    public static void main(String[] args) throws InterruptedException {
        ReservationDTO reservation = DataFakerUtil.generateFakeReservation();
        reservation.getItinerary().setPrice(null);

        VirtualThreadsExercises exercises = new VirtualThreadsExercises();

        System.out.println("---------------------------------------");
        exercises.validarReserva(reservation);

        System.out.println("---------------------------------------");
        exercises.procesarSegmentos(reservation);

        System.out.println("---------------------------------------");
        exercises.buscarPasajeroPorNombre(reservation, reservation.getPassengers().get(0).getFirstName());
    }

    // Ejercicio 4: Procesar cada segmento de vuelo con Virtual Threads (Builder)
    public void procesarSegmentos(ReservationDTO reserva) {
        Thread.Builder builder = Thread.ofVirtual().name("segmento-", 0);
        for (SegmentDTO segmento : reserva.getItinerary().getSegment()) {
            builder.start(() -> System.out.println("Segmento: " + segmento.getDeparture() + " → " + segmento.getArrival()));
        }
    }


    // Ejercicio 6: Validar múltiples condiciones en paralelo (Builder, join)
    public void validarReserva(ReservationDTO reserva) throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual();
        Thread contacto = builder.unstarted(() -> {
            if (reserva.getItinerary() == null || reserva.getItinerary().getPrice() == null) {
                System.out.println("Precio inválido");
            }
        });

        Thread pasajeros = builder.unstarted(() -> {
            boolean algunoSinEmail = reserva.getPassengers().stream().anyMatch(p -> p.getEmail() == null);
            if (algunoSinEmail) {
                System.out.println("Al menos un pasajero no tiene email");
            }
        });

        contacto.start();
        pasajeros.start();

        contacto.join();
        pasajeros.join();
    }

    // Ejercicio 7: Buscar pasajero por nombre (startVirtualThread)
    public void buscarPasajeroPorNombre(ReservationDTO reserva, String nombre) throws InterruptedException {
        for (PassengerDTO p : reserva.getPassengers()) {
            Thread.startVirtualThread(() -> {
                if (p.getFirstName().equalsIgnoreCase(nombre)) {
                    System.out.println("Pasajero encontrado: " + p.getFirstName());
                }
            });
            Thread.sleep(1000); // Simular tiempo de procesamiento de búsqueda de pasajero por nombre
        }
    }

}
