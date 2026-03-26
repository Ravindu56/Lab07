package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentGet extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentGet demo = new HttpStudentGet();
        var client  = demo.httpClient();
        var request = demo.httpRequestGET();

        // a. Synchronous GET - list all students
        System.out.println("=== Task 01(a): List All Students ===");
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.printf("Status: %d%n", response.statusCode());
        System.out.printf("Body:   %s%n", response.body());

        // Async demonstration (uppercase output)
        System.out.println("\n--- Async Response ---");
        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        responseFuture
                .thenApply(HttpResponse::body)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println)
                .join();
    }
}
