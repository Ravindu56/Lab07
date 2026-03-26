package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

// Task 02(b): Authenticate using Java's Authenticator class
public class HttpStudentAuthenticator {

    private static final String SECURE_URI =
            "http://localhost:8080/lab07-student-server/students/secure/1";

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("=== Task 02(b): Authenticate with Authenticator Class ===");

        // HttpClient built with an Authenticator
        // When server returns 401 + WWW-Authenticate, HttpClient automatically
        // calls getPasswordAuthentication() and retries with the credentials
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(1000))
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        System.out.println("Authenticator invoked for host: "
                                + getRequestingHost());
                        return new PasswordAuthentication(
                                "student",
                                "password123".toCharArray()
                        );
                    }
                })
                .build();

        // Plain GET request - no Authorization header set manually
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(SECURE_URI))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // HttpClient handles 401 challenge-response automatically
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.printf("Status : %d%n", response.statusCode());
        System.out.printf("Body   : %s%n", response.body());
    }
}
