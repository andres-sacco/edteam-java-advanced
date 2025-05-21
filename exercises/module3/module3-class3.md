# Ejercicios: Módulo 3 - Clase 3

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

## **Ejercicio 1: Crear un pasajero y mostrar su email**

```java
var pasajero = new PassengerDTO();
pasajero.setEmail("juan@example.com");
System.out.println(pasajero.getEmail());
```

---

## **Ejercicio 2: Crear una reserva con 2 pasajeros y mostrar la cantidad**

```java
var p1 = new PassengerDTO(); p1.setEmail("a@x.com");
var p2 = new PassengerDTO(); p2.setEmail("b@x.com");
var reserva = new ReservationDTO();
reserva.setPassengers(List.of(p1, p2));
System.out.println(reserva.getPassengers().size());
```

---

## **Ejercicio 3: Calcular el total de pasajeros en una lista de reservas**

```java
var r1 = new ReservationDTO(); r1.setPassengers(List.of(new PassengerDTO(), new PassengerDTO()));
var r2 = new ReservationDTO(); r2.setPassengers(List.of(new PassengerDTO()));
var total = Stream.of(r1, r2).mapToInt(r -> r.getPassengers().size()).sum();
System.out.println(total);
```

---

## **Ejercicio 4: Mostrar emails únicos de los pasajeros de una reserva**

```java
var p1 = new PassengerDTO(); p1.setEmail("a@x.com");
var p2 = new PassengerDTO(); p2.setEmail("a@x.com");
var p3 = new PassengerDTO(); p3.setEmail("b@x.com");
var r = new ReservationDTO(); r.setPassengers(List.of(p1, p2, p3));
r.getPassengers().stream().map(PassengerDTO::getEmail).distinct().forEach(System.out::println);
```

---

## **Ejercicio 5: Calcular duración entre dos instantes**

```java
import java.time.*;
var salida = Instant.now();
var llegada = salida.plus(Duration.ofHours(3));
System.out.println(Duration.between(salida, llegada).toMinutes());
```

---

## **Ejercicio 6: Verificar si un pasajero es mayor de edad**

```java
var p = new PassengerDTO(); p.setBirthDate(LocalDate.of(2006, 1, 1));
System.out.println(Period.between(p.getBirthDate(), LocalDate.now()).getYears() >= 18);
```

---

## **Ejercicio 7: Simular un segmento y mostrar si es nocturno**

```java
var s = new SegmentDTO();
s.setDepartureHour(LocalTime.of(23, 30));
System.out.println(s.getDepartureHour().isAfter(LocalTime.of(22, 0)));
```

---

## **Ejercicio 8: Asignar precio a una reserva y mostrarlo**

```java
var precio = new PriceDTO(); precio.setAmount(199.99);
var r = new ReservationDTO(); r.setPrice(precio);
System.out.println(r.getPrice().getAmount());
```

---

## **Ejercicio 9: Mostrar nombre completo de un pasajero**

```java
var p = new PassengerDTO(); p.setFirstName("Ana"); p.setLastName("López");
System.out.println(p.getFirstName() + " " + p.getLastName());
```

---

## **Ejercicio 10: Calcular meses hasta la fecha de vuelo**

```java
var fechaVuelo = LocalDate.of(2025, 12, 25);
System.out.println(Period.between(LocalDate.now(), fechaVuelo).getMonths());
```

---

## **Ejercicio 11: Sumar los elementos de una lista**

```java
var numeros = List.of(10, 20, 30, 40);
int suma = numeros.stream().mapToInt(n -> n).sum();
System.out.println("Suma: " + suma);
```

---

##  **Ejercicio 12: Filtrar palabras con más de 5 letras**

```java
var palabras = List.of("sol", "computadora", "árbol", "teclado", "luz");
palabras.stream().filter(p -> p.length() > 5).forEach(System.out::println);
```

---

##  **Ejercicio 13: Crear un `Map` y acceder a un valor**

```java
var mapa = Map.of("clave1", 100, "clave2", 200);
System.out.println(mapa.get("clave1"));
```

---

##  **Ejercicio 14: Usar un `Optional` para evitar `null`**

```java
Optional<String> nombre = Optional.ofNullable(null);
System.out.println(nombre.orElse("Valor por defecto"));
```

---

##  **Ejercicio 15: Obtener el día de la semana actual**

```java
import java.time.*;
System.out.println(LocalDate.now().getDayOfWeek());
```

---

## **Ejercicio 16: Ordenar una lista alfabéticamente**

```java
var nombres = new ArrayList<>(List.of("Juan", "Ana", "Pedro"));
Collections.sort(nombres);
System.out.println(nombres);
```

---

##  **Ejercicio 17: Contar cuántos números son mayores a 10**

```java
var lista = List.of(5, 12, 18, 3, 9);
long conteo = lista.stream().filter(n -> n > 10).count();
System.out.println("Mayores a 10: " + conteo);
```

---

##  **Ejercicio 18: Crear una clase interna simple**

```java
class Persona {
    String nombre;
    Persona(String nombre) { this.nombre = nombre; }
    String saludar() { return "Hola, " + nombre; }
}
var p = new Persona("Lucía");
System.out.println(p.saludar());
```

---

##  **Ejercicio 19: Medir duración de una tarea simulada**

```java
import java.time.*;
var inicio = Instant.now();
Thread.sleep(500);
var fin = Instant.now();
System.out.println(Duration.between(inicio, fin).toMillis() + " ms");
```

---

##  **Ejercicio 20: Generar una lista de números del 1 al 10**

```java
var numeros = java.util.stream.IntStream.rangeClosed(1, 10).boxed().toList();
System.out.println(numeros);
```

---

##  **Ejercicio 21: Agrupar palabras por longitud**

```java
var palabras = List.of("sol", "teclado", "luz", "pantalla", "monitor", "cable");
var agrupadas = palabras.stream().collect(Collectors.groupingBy(String::length));
agrupadas.forEach((k, v) -> System.out.println(k + ": " + v));
```

---

##  **Ejercicio 22: Encadenar `Optional` con `map` y `filter`**

```java
Optional<String> nombre = Optional.of("carlos");
var resultado = nombre
    .map(String::toUpperCase)
    .filter(n -> n.startsWith("C"))
    .orElse("Nombre no válido");
System.out.println(resultado);
```

---

##  **Ejercicio 23: Ejecutar tareas asincrónicas con `CompletableFuture`**

```java
CompletableFuture.supplyAsync(() -> "Tarea 1")
    .thenApply(res -> res + " completada")
    .thenAccept(System.out::println);
```

---

##  **Ejercicio 24: Calcular frecuencia de palabras en una oración**

```java
var texto = "hola mundo hola teclado mundo hola";
var frec = Arrays.stream(texto.split(" "))
    .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
System.out.println(frec);
```

---

##  **Ejercicio 25: Encontrar el número más frecuente en una lista**

```java
var numeros = List.of(1, 2, 3, 2, 4, 2, 1);
var masFrecuente = numeros.stream()
    .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
    .entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .map(Map.Entry::getKey)
    .orElse(-1);
System.out.println(masFrecuente);
```

---

##  **Ejercicio 26: Usar una clase anónima para un comparador personalizado**

```java
var lista = List.of("teclado", "ratón", "pantalla");
var ordenada = new ArrayList<>(lista);
ordenada.sort(new Comparator<String>() {
    public int compare(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }
});
System.out.println(ordenada);
```

---

##  **Ejercicio 27: Calcular edades a partir de fechas de nacimiento**

```java
var fechas = List.of(
    LocalDate.of(1990, 5, 2),
    LocalDate.of(2000, 10, 15),
    LocalDate.of(2010, 1, 1)
);
var edades = fechas.stream()
    .map(f -> Period.between(f, LocalDate.now()).getYears())
    .toList();
System.out.println(edades);
```

---

##  **Ejercicio 28: Simular un pipeline funcional de procesamiento**

```java
Function<String, String> quitarEspacios = s -> s.trim();
Function<String, String> aMayusculas = String::toUpperCase;
Function<String, String> agregarSigno = s -> s + "!";
var resultado = quitarEspacios.andThen(aMayusculas).andThen(agregarSigno).apply("  hola  ");
System.out.println(resultado);
```

---

##  **Ejercicio 29: Crear y usar un `record`**

```java
record Persona(String nombre, int edad) {}
var p = new Persona("Ana", 30);
System.out.println(p.nombre() + " tiene " + p.edad() + " años.");
```

---

##  **Ejercicio 30: Pattern Matching con `instanceof` (Java 16+)**

```java
Object obj = "texto";
if (obj instanceof String s && s.length() > 4) {
    System.out.println("Es un string largo: " + s);
} else {
    System.out.println("No es string o es corto");
}
```

---

