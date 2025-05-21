# Ejercicios: Módulo 4 - Clase 4

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.


###  **Ejercicio 1: Comparar uso de memoria con caracteres ASCII vs Unicode**

> Se desea crear instancias de `PassengerDTO` con nombres simples (ASCII) y otros con caracteres extendidos, para ver el uso interno de memoria.

---

### **Ejercicio 2: Generar muchas reservas con emails simples y ver Compact Strings en acción**

> Crear 10.000 instancias con emails como `"a@a.com"` y ver la eficiencia del pool de cadenas.

---

###  **Ejercicio 3: Ver si un campo como `reservationId` genera Compact Strings**

> Asignar distintos tipos de cadenas al `reservationId` y analizar si son internamente compactadas.

---

###  **Ejercicio 4: Crear un archivo JAR con tus clases de dominio**

> Empaquetar tus DTO en un JAR.

---

###  **Ejercicio 5: Crear un archivo CDS con las clases de tus DTO**

> Usar `java -Xshare:dump` para generar un caché de clases.

---

###  **Ejercicio 6: Ejecutar una app usando CDS con tus clases del dominio**

> La aplicación debería cargar más rápido si CDS está activo.

---

###  **Ejercicio 7: Verificar si CDS está habilitado en tiempo de ejecución**

> Imprimir propiedades del sistema o usar comandos.

---

###  **Ejercicio 8: Crear benchmark de arranque con y sin CDS**

> Comparar el tiempo de arranque de una app simple que instancia `ReservationDTO` muchas veces.

---

###  **Ejercicio 9: Generar automáticamente un archivo de lista de clases usadas**

> Útil para generar dinámicamente el listado para usar luego con `-Xshare:dump`.

---


### Comandos

En esta clase se utilizaron los siguientes comandos:

```
jar --create --file=dominio.jar -C target/classes .

java -Xshare:off -XX:DumpLoadedClassList=lista.txt -cp dominio.jar CompactStringsExercises.java
```