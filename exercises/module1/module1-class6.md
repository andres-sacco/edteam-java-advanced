# Ejercicios: Módulo 1 - Clase 6

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

## **Ejercicio 1: `Email` como Value Class (usado en `PassengerDTO`)**

```java
public class PassengerDTO {
    private String email;
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

## **Ejercicio 2: `Documento` como Value Class (document type y number en uno)**

```java
public class PassengerDTO {
    private String documentType;
    private String documentNumber;
}
```
---

## **Ejercicio 3: `Precio` como Value Class (en lugar de BigDecimal suelto)**


```java
public class PriceDTO {
    private BigDecimal basePrice;
    private BigDecimal totalPrice;
}
```
---

## **Ejercicio 4: `Aeropuerto` como Value Class (para `origin` y `destination`)**

```java
public class SegmentDTO {
    private String origin;
    private String destination;
}
```
---

## **Ejercicio 5: `HoraVuelo` como Value Class (formato ISO con validación)**

```java
public class SegmentDTO {
    private String departure;
}
```

---

## **Ejercicio 6: `Moneda` como Value Class (útil si usás multilocalización)**

```java
public class PriceDTO {
    private String currency;
}
```
---

## **Ejercicio 7: `ReservaId` como Value Class (clave primaria fuerte)**

```java
public class ReservationDTO {
    private String reservationId;
}
```


---
