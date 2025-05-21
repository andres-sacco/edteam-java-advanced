# Ejercicios: Módulo 2 - Clase 5

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.


## **Ejercicio 1: Pasar un ReservationDTO como contexto en un Virtual Thread (newInstance, get)**
> Se espera que se pase una reserva como contexto y acceda a ella desde dentro del bloque run, usando ScopedValue.get().

---

## **Ejercicio 2: Imprimir email de contacto solo si hay valor (isBound)**
> Se pide validar si el ScopedValue está ligado antes de intentar acceder al valor. Se usa isBound() para evitar excepciones.

---

## **Ejercicio 3: Calcular cantidad de pasajeros desde un contexto (get)**
> Se debe usar ScopedValue como fuente de datos de entrada sin pasarlo como parámetro, utilizando .call(...) y .get().

---


## **Ejercicio 4: Encadenar procesamiento de segmentos con Scoped Value (where)**
> El ejercicio requiere encapsular un SegmentDTO en un ScopedValue y utilizar su información dentro de una operación encadenada.

---


## **Ejercicio 5: Usar ScopedValue para loggear el nombre del pasajero actual en múltiples threads**
> Se debe aplicar ScopedValue.where(...) por cada hilo virtual para establecer un contexto único por pasajero y loguearlo.

---


## **Ejercicio 6: Validar si se está accediendo fuera de un contexto (isBound)**
> Se espera que se verifique si el contexto fue establecido correctamente antes de operar sobre el valor, para evitar fallos en ejecución.

---


## **Ejercicio 7: Mostrar resumen de reserva con varios Scoped Values anidados**
> Se debe usar múltiples ScopedValue para manejar distintos tipos de contexto al mismo tiempo, aprovechando la anidación segura.

---

## **Ejercicio 8: Utilizar ScopedValue con un Callable que retorna el email de contacto**
> Se espera implementar una llamada segura y reutilizable que devuelva el email sin pasarlo como argumento, usando .call() con retorno.

---