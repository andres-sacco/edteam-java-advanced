package com.edteam.reservations.module.two;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.module.two.other.EmailsUnicosTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

//Obtener lista de emails únicos de pasajeros
public class ForkJoinExercises {
    public static void main(String[] args) {
        // Crear pasajeros
        PassengerDTO pasajero1 = new PassengerDTO();
        pasajero1.setEmail("juan@example.com");

        PassengerDTO pasajero2 = new PassengerDTO();
        pasajero2.setEmail("ana@example.com");

        PassengerDTO pasajero3 = new PassengerDTO();
        pasajero3.setEmail("juan@example.com"); // Duplicado

        // Crear reservas
        ReservationDTO reserva1 = new ReservationDTO();
        reserva1.setPassengers(List.of(pasajero1, pasajero2));

        ReservationDTO reserva2 = new ReservationDTO();
        reserva2.setPassengers(List.of(pasajero3));

        // Lista grande para probar el umbral
        List<ReservationDTO> reservas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            reservas.add(i % 2 == 0 ? reserva1 : reserva2);
        }

        // Ejecutar EmailsUnicosTask
        ForkJoinPool pool = new ForkJoinPool();
        EmailsUnicosTask task = new EmailsUnicosTask(reservas, 0, reservas.size());
        Set<String> emailsUnicos = pool.invoke(task);

        // Mostrar resultados
        System.out.println("Emails únicos encontrados:");
        emailsUnicos.forEach(System.out::println);

        pool.shutdown();

    }
}
