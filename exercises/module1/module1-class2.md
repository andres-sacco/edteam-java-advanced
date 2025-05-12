# Ejercicios: Módulo 1 - Clase 2

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

### **Ejercicio 1: Obtener el total del precio de una reserva**
```java
public BigDecimal obtenerTotalPrice(ReservationDTO reserva) {
    if (reserva != null && reserva.getItinerary() != null && reserva.getItinerary().getPrice() != null) {
        return reserva.getItinerary().getPrice().getTotalPrice();
    }
    return BigDecimal.ZERO;
}
```
---

###  **Ejercicio 2: Obtener el correo electrónico del primer pasajero**

```java
public String obtenerEmailPrimerPasajero(ReservationDTO reserva) {
    if (reserva != null && reserva.getPassengers() != null && !reserva.getPassengers().isEmpty()) {
        PassengerDTO pasajero = reserva.getPassengers().get(0);
        if (pasajero.getEmail() != null) {
            return pasajero.getEmail();
        }
    }
    return "sin-email";
}
```

---

### **Ejercicio 3: Obtener el ID del segmento inicial**


```java
public Long obtenerPrimerSegmentoId(ItineraryDTO itinerary) {
    if (itinerary != null && itinerary.getSegment() != null && !itinerary.getSegment().isEmpty()) {
        return itinerary.getSegment().get(0).getId();
    }
    return null;
}
```
---

### **Ejercicio 4: Obtener el apellido del pasajero**


```java
public String obtenerApellido(PassengerDTO pasajero) {
    if (pasajero != null && pasajero.getLastName() != null) {
        return pasajero.getLastName();
    }
    return "Desconocido";
}
```
---

### **Ejercicio 5: Validar si el número de documento está presente**

```java
public boolean documentoPresente(PassengerDTO pasajero) {
    return pasajero != null && pasajero.getDocumentNumber() != null;
}
```
---

### **Ejercicio 6: Obtener la fecha de creación de una reserva**

```java
public LocalDate obtenerFechaCreacion(ReservationDTO reserva) {
    if (reserva != null && reserva.getCreationDate() != null) {
        return reserva.getCreationDate();
    }
    return LocalDate.now();
}
```
---

###  **Ejercicio 7: Verificar si hay precio base disponible**

```java
public boolean hayPrecioBase(ItineraryDTO itinerary) {
    return itinerary != null &&
           itinerary.getPrice() != null &&
           itinerary.getPrice().getBasePrice() != null;
}
```

---

### **Ejercicio 8: Usar orElseThrow para validar datos obligatorios**


```java
public BigDecimal obtenerBasePriceObligatorio(ReservationDTO reserva) {
    if (reserva == null || reserva.getItinerary() == null || reserva.getItinerary().getPrice() == null) {
        throw new IllegalStateException("Falta el precio base en la reserva");
    }
    return reserva.getItinerary().getPrice().getBasePrice();
}
```
---

### **Ejercicio 9: Usar orElseGet para valor por defecto calculado**

```java
public LocalDate obtenerFechaConGenerador(ReservationDTO reserva) {
    if (reserva != null && reserva.getCreationDate() != null) {
        return reserva.getCreationDate();
    }
    return LocalDate.now();
}
```

---
### **Ejercicio 10: Usar `ifPresent` para realizar una acción si hay valor**

```java
public void imprimirEmailPasajero(PassengerDTO pasajero) {
    if (pasajero != null && pasajero.getEmail() != null) {
        System.out.println("Email del pasajero: " + pasajero.getEmail());
    }
}
```
---

