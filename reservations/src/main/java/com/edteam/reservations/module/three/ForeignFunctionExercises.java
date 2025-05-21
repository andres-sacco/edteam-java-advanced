package com.edteam.reservations.module.three;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class ForeignFunctionExercises {

    public static void main(String[] args) throws Throwable {
        ForeignFunctionExercises exercises = new ForeignFunctionExercises();
        exercises.llamarStrlenC();
        exercises.obtenerPID();
    }

    // Ejercicio 1: Llamar a `strlen` desde la libc (C)
    public void llamarStrlenC() throws Throwable {
        Linker linker = Linker.nativeLinker();
        SymbolLookup lookup = linker.defaultLookup(); // Java 22

        // Buscar símbolo 'strlen'
        MemorySegment strlenAddr = lookup.find("strlen").orElseThrow();

        // Definir descriptor de la función: size_t strlen(const char *)
        MethodHandle strlen = linker.downcallHandle(
                strlenAddr,
                FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
        );

        // Crear cadena en memoria nativa
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment cStr = arena.allocateFrom("Hola desde Java");

            // Invocar strlen
            long len = (long) strlen.invoke(cStr);
            System.out.println("Longitud de la cadena: " + len);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    // Ejercicio 5: Llamar a `getpid` para obtener el ID del proceso
    public void obtenerPID() throws Throwable {
        Linker linker = Linker.nativeLinker();
        SymbolLookup lookup = Linker.nativeLinker().defaultLookup();

        var symbol = lookup.find("getpid").orElseThrow();

        MethodHandle getpid = linker.downcallHandle(
                symbol,
                FunctionDescriptor.of(ValueLayout.JAVA_INT) // retorno: int
        );

        int pid = (int) getpid.invoke();
        System.out.println("PID actual: " + pid);
    }

}
