# Ejercicios: Módulo 1 - Clase 5

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

## **Ejercicio 1: Validar tipo de objeto con `instanceof` (antes y después)**

```java
public String obtenerNombreSiPasajero(Object obj) {
    if (obj instanceof PassengerDTO) {
        PassengerDTO p = (PassengerDTO) obj;
        return p.getFirstName();
    }
    return "No es pasajero";
}
```
---

## **Ejercicio 2: Mostrar email solo si es PassengerDTO y tiene uno**

```java
public String mostrarEmail(Object obj) {
    if (obj instanceof PassengerDTO) {
        PassengerDTO p = (PassengerDTO) obj;
        if (p.getEmail() != null) {
            return p.getEmail();
        }
    }
    return "No disponible";
}
```
---

## **Ejercicio 3: Mostrar nombre si es `PassengerDTO`, destino si es `SegmentDTO`**

```java
public String mostrarInfo(Object obj) {
    if (obj instanceof PassengerDTO) {
        PassengerDTO p = (PassengerDTO) obj;
        return "Pasajero: " + p.getFirstName();
    } else if (obj instanceof SegmentDTO) {
        SegmentDTO s = (SegmentDTO) obj;
        return "Segmento a: " + s.getDestination();
    }
    return "Desconocido";
}
```

---

##  **Ejercicio 4: Obtener total si es PriceDTO, si no, null**


```java
public BigDecimal obtenerTotal(Object obj) {
    if (obj instanceof PriceDTO) {
        return ((PriceDTO) obj).getTotalPrice();
    }
    return null;
}
```

---

##  **Ejercicio 5: Validar tipo y atributo con `&&`**
```java
public boolean pasajeroConEmail(Object obj) {
    if (obj instanceof PassengerDTO) {
        PassengerDTO p = (PassengerDTO) obj;
        return p.getEmail() != null && !p.getEmail().isEmpty();
    }
    return false;
}
```
---

## **Ejercicio 6: `switch` por tipo con múltiples casos**

```java
public String tipoEntidad(Object obj) {
    if (obj instanceof PassengerDTO) return "Pasajero";
    if (obj instanceof SegmentDTO) return "Segmento";
    if (obj instanceof PriceDTO) return "Precio";
    return "Otro";
}
```
---

## **Ejercicio 7: Validar tipo y atributo con `switch` y `when`**

```java
public String validarTipo(Object obj) {
    if (obj instanceof PassengerDTO) {
        PassengerDTO p = (PassengerDTO) obj;
        if (p.getFirstName() != null && p.getFirstName().startsWith("A")) {
            return "Pasajero con A";
        }
    }
    return "Otro";
}
```
---
