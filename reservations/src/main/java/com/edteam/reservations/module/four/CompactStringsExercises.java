package com.edteam.reservations.module.four;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;

import java.util.ArrayList;
import java.util.List;

public class CompactStringsExercises {

    public static void main(String[] args) throws InterruptedException {
        CompactStringsExercises exercises = new CompactStringsExercises();
        exercises.compararUsoMemoria();

        exercises.generarReservasConEmailsSimples();
    }

    // Ejercicio 1: Comparar uso de memoria con caracteres ASCII vs Unicode
    public void compararUsoMemoria() {
        PassengerDTO ascii = new PassengerDTO();
        ascii.setFirstName("Juan"); // Compact String (Latin-1)

        PassengerDTO unicode = new PassengerDTO();
        unicode.setFirstName("张伟"); // No compactable (UTF-16)

        System.out.println("ASCII: " + ascii.getFirstName());
        System.out.println("Unicode: " + unicode.getFirstName());

    }

    // Ejercicio 2: Generar muchas reservas con emails simples y ver Compact Strings en acción
    public void generarReservasConEmailsSimples() throws InterruptedException {
        List<ReservationDTO> reservas = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            PassengerDTO p = new PassengerDTO();
            p.setEmail("a@a.com");
            ReservationDTO r = new ReservationDTO();
            r.setPassengers(List.of(p));
            reservas.add(r);
            Thread.sleep(10);
        }

    }
}
