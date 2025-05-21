package com.edteam.reservations.module.four;

import com.edteam.reservations.model.PassengerDTO;

import java.util.ArrayList;
import java.util.List;

public class CompactObjectHeadersExercises {

    public static void main(String[] args) {
        CompactObjectHeadersExercises exercises = new CompactObjectHeadersExercises();
        exercises.compararTamanioObjetoConHeaders();
    }

    // Ejercicio 1: Comparar tamaño de objeto con y sin headers
    public void compararTamanioObjetoConHeaders() {
        List<PassengerDTO> pasajeros = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            PassengerDTO p = new PassengerDTO();
            p.setFirstName("Juan");
            p.setLastName("Pérez");
            pasajeros.add(p);
        }
        System.out.println("Pasajeros creados: " + pasajeros.size());
    }
}
