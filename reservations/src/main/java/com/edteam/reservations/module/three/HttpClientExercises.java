package com.edteam.reservations.module.three;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExercises {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClientExercises exercises = new HttpClientExercises();
        exercises.obtenerCuerpoRespuestaGet();

        System.out.println("--------------------");
        exercises.realizarSolicitudPostConCuerpoJson();

        System.out.println("--------------------");
        exercises.enviarEncabezadosPersonalizados();
    }

    // Ejercicio 1: Realizar un GET simple y mostrar el cuerpo de la respuesta
    public void obtenerCuerpoRespuestaGet() throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body:\n" + response.body());
    }

    // Ejercicio 2: Realizar una solicitud POST con cuerpo JSON
    public void realizarSolicitudPostConCuerpoJson() throws IOException, InterruptedException {
        String json = """
            {
              "title": "foo",
              "body": "bar",
              "userId": 1
            }
            """;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Body:\n" + response.body());
    }

    //  Ejercicio 6: Enviar encabezados personalizados
    public void enviarEncabezadosPersonalizados() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/headers"))
                .header("X-Curso", "Java Avanzado")
                .header("X-Token", "abc123")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
