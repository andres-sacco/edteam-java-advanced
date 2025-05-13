# Curso: Java Avanzado: Evolución y Mejoras del Lenguaje

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Este repositorio contiene todo lo necesario para poder comenzar el curso.

## Tabla de contenidos

Los siguientes son los puntos más importantes en este archivo:
- [Requisitos](#requisitos)
- [Comprobar requisitos](#comprobar-requisitos)
- [Ejercicios](#ejercicios)

## Requisitos

Para poder realizar el curso necesitas tener instalado en tu computadora las siguientes herramientas:
- [Java](http://jdk.java.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

Si no tienes algunas de estas herramientas instaladas en tu computadora, sigue las instrucciones en la documentación oficial de cada herramienta o los videos creados como guía para esta materia.

## Comprobar requisitos

Si instalaste en tu computadora algunas de estas herramientas anteriormente o lo acabas de hacer ahora, verifica si todo funciona bien.

- Comprueba si la versión de Java está correctamente instalada usando el siguiente comando:
   ````
   % java -version
   openjdk 21.0.2 2024-01-16
   OpenJDK Runtime Environment GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30)
   OpenJDK 64-Bit Server VM GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30, mixed mode, sharing)
   ````

- Comprueba si la versión de Maven en tu computadora es 3.8.0 o superior. Podés ver qué versión de Maven tenés usando el siguiente comando:
   ````
   % mvn --version
   Apache Maven 3.8.3
   Maven home: /usr/share/maven
   ````

- Comprueba si tienes instalado de manera correcta en tu computadora Git usando el siguiente comando:
   ````
   % git --version
   git version 2.34.1
   ````
  
## Ejercicios
Este curso contiene una serie de ejercicios para que todos los estudiantes puedan practicar mas alla de lo que cada clase muestre.

### Módulo 1: Introducción
- [Clase 2 - Optional](./exercises/module1/module1-class2.md)
- [Clase 3 - Switch Expressions](./exercises/module1/module1-class3.md)
- [Clase 4 - Text Blocks](./exercises/module1/module1-class4.md)
- [Clase 5 - Pattern Matching](./exercises/module1/module1-class5.md)
- [Clase 6 - Value Classes](./exercises/module1/module1-class6.md)

### Módulo 2: Concurrencia y paralelismo
- [Clase 1 - Fork/Join Framework y ExecutorService](./exercises/module2/module2-class1.md)
- [Clase 2 - CompletableFuture](./exercises/module2/module2-class2.md)
- [Clase 3 - Structured Concurrency](./exercises/module2/module2-class3.md)
- [Clase 4 - Virtual Threads](./exercises/module2/module2-class4.md)
- [Clase 5 - Scoped Values](./exercises/module2/module2-class5.md)

### Módulo 3: API, librerias estándar y herramientas
- [Clase 1 - Date/Time API](./exercises/module3/module3-class1.md)
- [Clase 2 - NIO.2](./exercises/module3/module3-class2.md)
- [Clase 3 - JShell](./exercises/module3/module3-class3.md)
- [Clase 4 - HttpClient API](./exercises/module3/module3-class4.md)
- [Clase 5 - Foreign Function & Memory API](./exercises/module3/module3-class5.md)
- [Clase 6 - API de Archivos de Clase](./exercises/module3/module3-class6.md)

### Módulo 4: Gestión de memoria y rendimiento
- [Clase 1 - G1 Garbage Collector](./exercises/module4/module4-class1.md)
- [Clase 2 - Z Garbage Collector](./exercises/module4/module4-class2.md)
- [Clase 3 - Shenandoah Garbage Collector](./exercises/module4/module4-class3.md)
- [Clase 4 - Compact Strings y CDS](./exercises/module4/module4-class4.md)
- [Clase 5 - Reducción del tamaño de encabezados de objetos](./exercises/module4/module4-class5.md)
