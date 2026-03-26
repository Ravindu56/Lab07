package lk.ac.jfn.ec9590.lab07;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public abstract class HttpStudentClientMain {
    public static final String HTTP_STUDENTS_URI = "http://localhost:8080/xxxxxxx";

    public HttpClient httpClient() {
        return HttpClient
                .newBuilder()
                .connectTimeout(Duration.ofMillis(500))
                .build();
    }
//Get the list of all students
    public HttpRequest httpRequestGET() {
        return HttpRequest
                .newBuilder()
                .uri(------------------))
                .header("Content-Type", "application/json")
                .--------------------------.
                .build();
    }

    public HttpRequest getHttpRequestPOST(String json) {
        return HttpRequest
                .newBuilder()
                .uri(-------------------------))
                .header("Content-Type", "application/json")
                .-------------------
                .build();
    }

    public HttpRequest getHttpRequestPUT(int regNo, String json) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(-------------------))
                .header("Content-Type", "application/json")
                .------------------------
                .build();
    }
    public HttpRequest httpRequestDELETE(int regno) {
        return HttpRequest
                .newBuilder()
                .uri(------------------------------------))
                .header("Content-Type", "application/json")
                .-----------------------------------
                .build();
    }
}
