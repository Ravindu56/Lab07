package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import lk.ac.jfn.ec9590.lab07.HttpStudentClientMain;

public class HttpStudentGet extends HttpStudentClientMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentGet demo = new HttpStudentGet();
        var client =  demo.httpClient();
        var request = demo.httpRequestGET();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.printf("Status %s \n", response.statusCode());
        System.out.printf("Body %s \n", response.body());

        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        responseFuture
                .thenApply(HttpResponse::body)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println)
                .join();
    }
}
