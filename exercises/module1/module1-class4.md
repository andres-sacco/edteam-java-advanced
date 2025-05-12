# Ejercicios: Módulo 1 - Clase 4

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

## **Ejercicio 1: Mostrar información básica de un pasajero con `formatted`**


```java
public String resumenPasajero(PassengerDTO p) {
    return "Nombre: " + p.getFirstName() + "\n" +
           "Apellido: " + p.getLastName() + "\n" +
           "Documento: " + p.getDocumentNumber();
}
```

---

## **Ejercicio 2: Resumen de reserva con `stripIndent()`**


```java
public String resumenReserva(ReservationDTO r) {
    return "Reserva:\n" +
           "  ID: " + r.getReservationId() + "\n" +
           "  Fecha: " + r.getCreationDate();
}
```

---

## **Ejercicio 3: Ruta de vuelo con `formatted`**


```java
public String rutaVuelo(SegmentDTO s) {
    return "Vuelo de " + s.getOrigin() + " a " + s.getDestination();
}
```

---

## **Ejercicio 4: Tabla de precios con `stripIndent()`**

```java
public String tablaPrecios(PriceDTO p) {
    return "Precios:\n" +
           "  Base: " + p.getBasePrice() + "\n" +
           "  Total: " + p.getTotalPrice();
}
```
---

##  **Ejercicio 5: Mensaje con `translateEscapes()`**


```java
public String mensajeConSaltos() {
    return "Línea 1\\nLínea 2\\nLínea 3";
}
```

---

## **Ejercicio 6: Mensaje multilínea con tabulaciones (`translateEscapes()`)**


```java
public String mensajeTabulado() {
    return "ID\\tNombre\\tApellido";
}
```
---

## **Ejercicio 7: Mensaje dinámico para error con `formatted()`**


```java
public String errorSegmento(String campo) {
    return "Error: el campo '" + campo + "' no puede ser nulo.";
}
```

---