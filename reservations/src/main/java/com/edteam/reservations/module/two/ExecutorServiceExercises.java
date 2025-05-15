package com.edteam.reservations.module.two;

import com.edteam.reservations.model.ReservationDTO;
import com.edteam.reservations.util.DataFakerUtil;

import java.util.List;
import java.util.concurrent.*;

// Validar que todas las reservas tengan al menos un pasajero con email
public class ExecutorServiceExercises {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<ReservationDTO> reservations = DataFakerUtil.generateFakeReservations();

        ExecutorService executor = Executors.newFixedThreadPool(100);

        List<Callable<Boolean>> tareas = reservations.stream()
                .map(r -> (Callable<Boolean>) () -> r.getPassengers().stream()
                        .anyMatch(p -> p.getEmail() != null && !p.getEmail().isBlank()))
                .toList();

        List<Future<Boolean>> resultados = executor.invokeAll(tareas);

        boolean todasValidas = true;
        for (Future<Boolean> f : resultados) {
            if (!f.get()) {
                todasValidas = false;
                break;
            }
        }

        System.out.println("¿Todas las reservas tienen al menos un email válido?: " + todasValidas);
        executor.shutdown();
    }
}
