package com.edteam.reservations.module.four;

import java.util.ArrayList;
import java.util.List;

public class GCExercises {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Inicio de prueba GC con clase: " + GCExercises.class.getSimpleName() + " ---");

        long inicio = System.currentTimeMillis();
        testCargaYDescargaMasiva();
        testObjetosVivosLargoTiempo();
        testCargaConcurrente();
        long fin = System.currentTimeMillis();

        System.out.println("--- Duración total: " + (fin - inicio) + " ms ---");
    }

    // Crea y descarta muchos objetos rápidamente para simular carga típica
    public static void testCargaYDescargaMasiva() throws InterruptedException {
        List<byte[]> lista = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            lista.add(new byte[512 * 1024]); // 512 KB
            if (i % 10 == 0) {
                lista.removeFirst();
            }
            Thread.sleep(50);
        }
        System.out.println("Finalizado testCargaYDescargaMasiva");
    }

    // Simula estructuras que se mantienen vivas largo tiempo
    public static void testObjetosVivosLargoTiempo() throws InterruptedException {
        List<String[]> cache = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            cache.add(new String[1000]);
            if (i % 50 == 0) {
                cache.removeFirst();
            }
            Thread.sleep(5);
        }
        System.out.println("Finalizado testObjetosVivosLargoTiempo");
    }

    // Simula concurrencia con múltiples hilos
    public static void testCargaConcurrente() throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 20_000; j++) {
                    byte[] data = new byte[256 * 1024]; // 256 KB
                    if (j % 15 == 0) {
                        System.gc(); // sugerencia
                    }
                }
            });
            hilos.add(t);
            t.start();
        }
        for (Thread t : hilos) {
            t.join();
        }
        System.out.println("Finalizado testCargaConcurrente");
    }
}
