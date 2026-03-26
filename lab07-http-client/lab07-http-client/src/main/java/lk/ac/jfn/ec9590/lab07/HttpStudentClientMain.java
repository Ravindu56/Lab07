package lk.ac.jfn.ec9590.lab07;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public abstract class HttpStudentClientMain {

    public static final String HTTP_STUDENTS_URI = "http://localhost:8080/students";

    public HttpClient httpClient() {
        return HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofMillis(500))
                .build();
    }

    // a. GET - list all students
    public HttpRequest httpRequestGET() {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(HTTP_STUDENTS_URI))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    // b. POST - create a new student
    public HttpRequest getHttpRequestPOST(String json) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(HTTP_STUDENTS_URI))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
    }

    // c. PUT - update student email by regNo
    public HttpRequest getHttpRequestPUT(int regNo, String json) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(HTTP_STUDENTS_URI + "/" + regNo))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
    }

    // d. DELETE - delete a student by regNo
    public HttpRequest httpRequestDELETE(int regno) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(HTTP_STUDENTS_URI + "/" + regno))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }
}