package com.edteam.reservations.module.three;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.util.DataFakerUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NIO2Exercises {

    public static void main(String[] args) throws IOException {
        NIO2Exercises exercises = new NIO2Exercises();
        List<ReservationDTO> reservas = DataFakerUtil.generateFakeReservations();
        ReservationDTO reserva = DataFakerUtil.generateFakeReservation();

        exercises.guardarEmailsUnicos(reservas, Path.of("emails.txt"));

        System.out.println("---------------------------------------");
        exercises.guardarNombresPasajeros(reserva, Path.of("nombres.txt"));

        System.out.println("---------------------------------------");
        List<Path> paths = exercises.listarArchivosJava(Path.of("../"));
        paths.forEach(System.out::println);
    }

    // Ejercicio 1: Guardar emails únicos de pasajeros en un archivo
    public void guardarEmailsUnicos(List<ReservationDTO> reservas, Path ruta) throws IOException {
        Set<String> emails = new HashSet<>();
        for (ReservationDTO r : reservas) {
            for (PassengerDTO p : r.getPassengers()) {
                if (p.getEmail() != null) {
                    emails.add(p.getEmail());
                }
            }
        }
        Files.write(ruta, emails, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Ejercicio 5: Guardar los nombres completos de los pasajeros en un archivo
    public void guardarNombresPasajeros(ReservationDTO reserva, Path archivo) throws IOException {
        List<String> nombres = reserva.getPassengers().stream()
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .toList();
        Files.write(archivo, nombres);
    }

    // Ejercicio 8: Listar todos los archivos .java de un directorio
    public List<Path> listarArchivosJava(Path directorio) throws IOException {
        try (var stream = Files.walk(directorio)) {
            return stream
                    .filter(p -> Files.isRegularFile(p) && p.toString().endsWith(".java"))
                    .toList();
        }
    }

}
