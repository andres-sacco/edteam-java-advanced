package com.edteam.reservations.module.two.other;

import com.edteam.reservations.model.PassengerDTO;
import com.edteam.reservations.model.ReservationDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class EmailsUnicosTask extends RecursiveTask<Set<String>> {
    private final List<ReservationDTO> reservas;
    private final int inicio, fin;
    private static final int UMBRAL = 50;

    public EmailsUnicosTask(List<ReservationDTO> reservas, int inicio, int fin) {
        this.reservas = reservas;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Set<String> compute() {
        if (fin - inicio <= UMBRAL) {
            Set<String> emails = new HashSet<>();
            for (int i = inicio; i < fin; i++) {
                for (PassengerDTO p : reservas.get(i).getPassengers()) {
                    if (p.getEmail() != null) {
                        emails.add(p.getEmail());
                    }
                }
            }
            return emails;
        } else {
            int medio = (inicio + fin) / 2;
            var izq = new EmailsUnicosTask(reservas, inicio, medio);
            var der = new EmailsUnicosTask(reservas, medio, fin);
            izq.fork();
            der.fork();

            Set<String> izqResult = izq.join();
            Set<String> derResult = der.join();
            izqResult.addAll(derResult);
            return izqResult;
        }
    }

}
