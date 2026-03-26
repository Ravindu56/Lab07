package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;

// Task 02(a): Authenticate using HTTP Authorization Header manually
public class HttpStudentAuthHeader {

    private static final String SECURE_URI =
            "http://localhost:8080/lab07-student-server/students/secure/1";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(1000))
                .build();

        // --- Test 1: Valid credentials ---
        System.out.println("=== Task 02(a): Authenticate using HTTP Header ===");
        String credentials = "student:password123";
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
        String authHeaderValue = "Basic " + encoded;
        System.out.println("Encoded credentials : " + authHeaderValue);

        HttpRequest validRequest = HttpRequest.newBuilder()
                .uri(URI.create(SECURE_URI))
                .header("Content-Type", "application/json")
                .header("Authorization", authHeaderValue)
                .GET()
                .build();

        HttpResponse<String> validResponse = client.send(validRequest,
                HttpResponse.BodyHandlers.ofString());
        System.out.printf("Status : %d%n", validResponse.statusCode());
        System.out.printf("Body   : %s%n", validResponse.body());

        // --- Test 2: Wrong credentials (should return 401) ---
        System.out.println("\n--- Testing with WRONG credentials (expect 401) ---");
        String wrongEncoded = Base64.getEncoder()
                .encodeToString("wronguser:wrongpass".getBytes());

        HttpRequest wrongRequest = HttpRequest.newBuilder()
                .uri(URI.create(SECURE_URI))
                .header("Authorization", "Basic " + wrongEncoded)
                .GET()
                .build();

        HttpResponse<String> wrongResponse = client.send(wrongRequest,
                HttpResponse.BodyHandlers.ofString());
        System.out.printf("Status : %d%n", wrongResponse.statusCode());
        System.out.printf("Body   : %s%n", wrongResponse.body());
    }
}
