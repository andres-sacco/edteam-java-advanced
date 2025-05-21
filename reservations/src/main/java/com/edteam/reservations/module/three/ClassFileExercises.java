package com.edteam.reservations.module.three;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.reflect.AccessFlag;
import java.nio.file.Path;

public class ClassFileExercises {

    public static void main(String[] args) throws Exception {
        ClassFileExercises exercises = new ClassFileExercises();
        exercises.listarMetodos();

        exercises.tieneMetodoPublicoGetEmail();
    }

    // Ejercicio 1: Listar todos los métodos de una clase del dominio
    public void listarMetodos() throws IOException {
        Path path = Path.of("target/classes/com/edteam/reservations/model/PassengerDTO.class");

        ClassModel model = ClassFile.of().parse(path);

        System.out.println("Métodos de PassengerDTO:");
        model.methods().forEach(m -> System.out.println(m.methodName()));
    }

    // Ejercicio 3: Verificar si `PassengerDTO` tiene un metodo `getEmail` público
    public void tieneMetodoPublicoGetEmail() throws IOException {
        Path path = Path.of("target/classes/com/edteam/reservations/model/PassengerDTO.class");

        ClassModel model = ClassFile.of().parse(path);

        boolean tieneGetEmailPublico = model.methods().stream()
                .anyMatch(m ->
                        m.methodName().equals("getEmail") &&
                                m.flags().has(AccessFlag.PUBLIC)
                );

        System.out.println("¿PassengerDTO tiene un método público getEmail? " + tieneGetEmailPublico);
    }
}
