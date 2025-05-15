# Ejercicios: Módulo 2 - Clase 2

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

## **Ejercicio 1: Obtener cantidad de pasajeros (thenApply)**
Calcular la suma de todos los elementos de un arreglo grande usando RecursiveTask.

---

## **Ejercicio 2: Imprimir el email del contacto (thenAccept)**
Se accede al contacto de la reserva en segundo plano y luego se imprime su email. Usa thenAccept para ejecutar una acción basada en el resultado, sin retornar valor.

---

## **Ejercicio 3: Obtener precio total de un pasajero (thenApply)**
Permite calcular asincrónicamente el precio total de un pasajero. Si el precio no está disponible, devuelve cero. Útil para evitar errores por null.

---

## **Ejercicio 4: Obtener nombre completo del primer pasajero (thenApply)**
Transforma el primer pasajero de la reserva en un nombre completo, compuesto por su nombre y apellido. Ideal para comprender transformaciones encadenadas.

---


## **Ejercicio 5: Calcular precio total de todos los pasajeros (thenCompose)**
Ejemplo de composición asincrónica. Calcula el precio total de todos los pasajeros de una reserva, usando tareas independientes y luego combinándolas.

---

## **Ejercicio 6: Imprimir resumen después del cálculo (thenRun)**
Después de calcular el precio total de una reserva, se imprime el resultado y luego se ejecuta una acción adicional con thenRun. Muestra la utilidad de encadenar efectos secundarios.

---

## **Ejercicio 7: Verificar si hay pasajeros sin email (thenApply)**
Este ejercicio hace uso del Fork/Join Framework para recorrer una lista de reservas y detectar, de forma paralela, si existe al menos un pasajero con un nombre específico. El uso de RecursiveTask permite dividir el trabajo y acelerarlo, especialmente útil cuando se trata de búsquedas en datasets grande

---

## **Ejercicio 8: Composición de validaciones (thenCompose)**
Composición de validaciones dependientes: primero valida el contacto y luego que al menos un pasajero tenga email. Combina thenCompose y thenApply.

---


## **Ejercicio 9: Obtener email del contacto o valor por defecto (exceptionally)**
Permite continuar el flujo asincrónico incluso si ocurre una excepción, devolviendo un valor alternativo. Útil para evitar fallos inesperados por null.

---


## **Ejercicio 10: Manejar error en precio total con handle**
Usa handle para capturar excepciones y continuar el flujo sin lanzar errores.

---


## **Ejercicio 11: Usar join para bloquear y obtener el nombre del primer pasajero**
Aunque CompletableFuture es asincrónico, en este caso se bloquea usando join para obtener el resultado de manera directa.

---


## **Ejercicio 12: Calcular la suma total de precios con join**
Se espera que todos los futuros terminen con join, y luego se combinan los resultados manualmente.

---

## **Ejercicio 13: Simular error si no hay pasajeros en la reserva (exceptionally)**
Este ejercicio muestra cómo lanzar y capturar excepciones dentro de un CompletableFuture, devolviendo un valor seguro.

---