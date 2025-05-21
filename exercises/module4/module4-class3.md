# Ejercicios: Módulo 4 - Clase 3

Aqui encontraras una serie de ejercicios para poder practicar los conceptos relacionados con esta clase. Los mismos contienen un fragmento de codigo sin el uso del tema en cuestión y deben ser modificados para usarlo.

###  **Ejercicio 1: Crear una clase que pruebe el funcionamiento**

> Crear una clase que haga las pruebas para ver el funcionamiento del GC con VisualVM/FlightRecorder.

### Comandos

En esta clase se utilizaron los siguientes comandos:

```
java -XX:+PrintFlagsFinal | grep Use

java -Xmx256m -Xms256m -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -Xlog:gc* GCExercises.java


java -XX:+FlightRecorder -XX:StartFlightRecording=duration=60s,filename=demo_sgc.jfr -Dvisualvm.display.name=GC-ShenandoahGC -Xmx256m -Xms256m -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -Xlog:gc* GCExercises.java
```