# Ejercicios: Módulo 2 - Clase 3

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.


## **Ejercicio 1: Obtener nombres de todos los pasajeros en paralelo (fork + join + close)**
Se lanzan múltiples tareas para obtener nombres completos en paralelo. Se usa fork para iniciar tareas, join para esperar, y close (implícito en try-with-resources) para liberar recursos.

---

## **Ejercicio 2: Calcular precios individuales con cierre inmediato ante fallo (shutdownOnFailure)**
El objetivo es calcular en paralelo los precios de todos los pasajeros. Si algún cálculo lanza una excepción (por ejemplo, si getPrice() es null), todas las tareas deben ser detenidas automáticamente. Se debe aplicar correctamente shutdownOnFailure.

---


## **Ejercicio 3: Validar contacto y pasajeros, y cortar al primero que falle (shutdownOnFailure)**
Se busca validar en paralelo si la reserva tiene contacto con email y todos los pasajeros también lo tienen. Si alguna validación falla o lanza error, el proceso debe detenerse. Se debe manejar múltiples tareas booleanas y combinar resultados.

---


## **Ejercicio 4: Obtener precio base y total en paralelo y retornar suma (shutdownOnFailure)**
Se debe lanzar dos tareas que obtienen precios base y total, y devolver la suma. Se espera el uso correcto de fork, join y manejo de fallos al acceder al objeto PriceDTO.

---


## **Ejercicio 5: Verificar si hay pasajeros con un nombre específico (shutdownOnSuccess)**
El objetivo es buscar si algún pasajero tiene un nombre dado. Cuando se encuentre una coincidencia, el resto de las tareas debe cancelarse automáticamente. Se debe aplicar shutdownOnSuccess y validar correctamente el resultado.

---


## **Ejercicio 6: Comparar múltiples precios y devolver el mayor (shutdown)**
Se debe calcular en paralelo todos los precios totales de los pasajeros y devolver el más alto. Se espera el uso de shutdown explícito después del join.

---


## **Ejercicio 7: Generar resumen de reserva (join, throwIfFailed)**
Se espera que se combine resultados de tareas independientes para generar un resumen de la reserva. Este ejercicio afianza el uso de resultNow() tras join y manejo de errores con throwIfFailed().

---

## **Ejercicio 8: Forzar cancelación manual de tareas (shutdown)**
El objetivo es mostrar cómo cancelar tareas manualmente con shutdown si se cumple una condición externa. Se espera que se implemente correctamente la interrupción del procesamiento en curso.

---