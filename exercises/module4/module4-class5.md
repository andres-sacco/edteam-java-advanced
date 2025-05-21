# Ejercicios: Módulo 4 - Clase 5

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

###  **Ejercicio 1: Crear muchas instancias de `PassengerDTO` y observar uso de memoria**

> Se desea medir el uso de memoria de objetos repetidos para verificar si COH mejora el consumo.

```java
List<PassengerDTO> pasajeros = new ArrayList<>();
for (int i = 0; i < 1_000_000; i++) {
    PassengerDTO p = new PassengerDTO();
    p.setFirstName("Juan");
    p.setLastName("Pérez");
    pasajeros.add(p);
}
System.out.println("Pasajeros creados: " + pasajeros.size());
```

Ejecutar con:

```bash
java --enable-preview -XX:+UseCompactObjectHeaders -Xlog:gc* ClasePrincipal
```


### Comandos

En esta clase se utilizaron los siguientes comandos:

```
java --enable-preview -XX:+UnlockExperimentalVMOptions -XX:+UseCompactObjectHeaders -Xlog:gc*  -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=compactheaders.jfr CompactObjectHeadersExercises.java



java -Xlog:gc*  -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=withoutcompactheaders.jfr CompactObjectHeadersExercises.java
```
---

### **Ejercicio 2: Usar `reservationId` internamente compartido para detectar ahorro de headers**

> Cadenas iguales pueden compartir header, pero el objeto `ReservationDTO` sigue siendo distinto.

```java
List<ReservationDTO> reservas = new ArrayList<>();
for (int i = 0; i < 500_000; i++) {
    ReservationDTO r = new ReservationDTO();
    r.setReservationId("RESERVA-2025");
    reservas.add(r);
}
```

---

###  **Ejercicio 3: Usar `System.identityHashCode()` y sincronización para forzar descompactación**

> Ver qué operaciones fuerzan el regreso al header clásico (por ejemplo, sincronizar o calcular hash).

```java
PassengerDTO p = new PassengerDTO();
System.out.println("Hash antes: " + System.identityHashCode(p));

synchronized (p) {
    System.out.println("Dentro del bloque sincronizado.");
}

System.out.println("Hash después: " + System.identityHashCode(p));
```

---

###  **Ejercicio 4: Comparar instancias con y sin `identityHashCode`**

> Crear dos instancias, una con uso del `hash` y otra sin él, y comparar comportamiento.

```java
PassengerDTO p1 = new PassengerDTO();
PassengerDTO p2 = new PassengerDTO();
System.identityHashCode(p1); // esto lo descompacta
```

 Revisar con:

```bash
java -Xlog:gc* -XX:+UseCompactObjectHeaders -XX:+UnlockDiagnosticVMOptions -XX:+PrintFieldLayout
```
---

###  **Ejercicio 5: Crear millones de objetos simples (`new Object()`) y medir impacto**

> Objetivo poder visualizar mejora en overhead de memoria gracias a COH.

```java
List<Object> objetos = new ArrayList<>();
for (int i = 0; i < 2_000_000; i++) {
    objetos.add(new Object());
}
```

---
