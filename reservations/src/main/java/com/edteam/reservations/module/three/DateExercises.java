package com.edteam.reservations.module.three;

import java.time.*;
import java.util.List;

public class DateExercises {

    public static void main(String[] args) {
        DateExercises exercises = new DateExercises();

        System.out.println("¿Está dentro del horario? " + exercises.estaDentroDelHorario(LocalTime.of(22, 0), LocalTime.of(6, 0), LocalTime.now()));

        ZonedDateTime utc = exercises.convertirAUTC(LocalTime.of(15, 30), ZoneId.of("Europe/Madrid"));
        System.out.println("15:30 en Madrid equivale a UTC: " + utc);

        List<String> zonas = List.of("Europe/Madrid", "America/New_York", "Asia/Tokyo");
        exercises.mostrarZonas(zonas);
    }

    // Ejercicio 13: Verificar si un horario local está dentro de una franja válida (LocalTime)
    public boolean estaDentroDelHorario(LocalTime inicio, LocalTime fin, LocalTime actual) {
        if (inicio.isBefore(fin)) {
            return !actual.isBefore(inicio) && !actual.isAfter(fin);
        } else {
            return !actual.isBefore(inicio) || !actual.isAfter(fin);
        }
    }

    // Ejercicio 16: Mostrar el tiempo UTC y su equivalente local en múltiples zonas
    public void mostrarZonas(List<String> zonas) {
        Instant ahora = Instant.now();
        zonas.forEach(z -> {
            ZonedDateTime local = ahora.atZone(ZoneId.of(z));
            System.out.println(z + " → " + local.toLocalTime());
        });
    }

    // Ejercicio 20: Convertir una hora local a UTC conservando fecha y zona
    public ZonedDateTime convertirAUTC(LocalTime horaLocal, ZoneId zona) {
        LocalDate hoy = LocalDate.now(zona);
        ZonedDateTime localZoned = ZonedDateTime.of(hoy, horaLocal, zona);
        return localZoned.withZoneSameInstant(ZoneOffset.UTC);
    }
}

