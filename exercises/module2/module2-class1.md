# Ejercicios: Módulo 2 - Clase 1

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.


## **Ejercicio 1: Suma de elementos de un arreglo**
Calcular la suma de todos los elementos de un arreglo grande usando RecursiveTask.

---

## **Ejercicio 2: Búsqueda de un número en un arreglo**
Devolver si existe un valor en el arreglo de forma paralela.

---

## **Ejercicio 3: Calcular el total de todos los precios base de una lista de PriceDTO**
Dividir el procesamiento de precios y calcular la suma total usando RecursiveTask.

---

## **Ejercicio 4: Procesar una lista de ReservationDTO en paralelo para obtener el total de pasajeros**
En este ejercicio se utiliza ExecutorService para procesar múltiples reservas de manera paralela. Cada tarea calcula la cantidad de pasajeros en una reserva, y luego se suman todos los resultados para obtener el total general. Es una forma eficiente de aprovechar múltiples núcleos al trabajar con grandes volúmenes de datos.

---


## **Ejercicio 5: Validar múltiples segmentos de vuelo en paralelo**
Se propone validar la integridad de varios segmentos de vuelo (SegmentDTO) utilizando múltiples hilos. Cada tarea comprueba si el segmento tiene origen y destino definidos. Este enfoque permite validar una gran cantidad de segmentos en menor tiempo, ideal para preprocesamiento antes de almacenar o mostrar datos.

---

## **Ejercicio 6: Calcular precio total por reserva en paralelo**
En este caso, cada tarea calcula el precio total de una reserva sumando los precios totales de todos los pasajeros asociados. El procesamiento se realiza de forma paralela con ExecutorService y Callable, permitiendo manejar muchas reservas de forma eficiente y no bloqueante.

---

## **Ejercicio 7: Buscar si una reserva contiene un pasajero con nombre específico**
Este ejercicio hace uso del Fork/Join Framework para recorrer una lista de reservas y detectar, de forma paralela, si existe al menos un pasajero con un nombre específico. El uso de RecursiveTask permite dividir el trabajo y acelerarlo, especialmente útil cuando se trata de búsquedas en datasets grande

---