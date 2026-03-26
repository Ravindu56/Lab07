package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentPost extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentPost demo = new HttpStudentPost();
        var client = demo.httpClient();

        // b. Create a new student
        String json = """
                {
                  "name": "Kasun Pathirana",
                  "email": "kasun@eng.jfn.ac.lk",
                  "department": "Computer Engineering"
                }
                """;

        var request  = demo.getHttpRequestPOST(json);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("=== Task 01(b): Create New Student ===");
        System.out.printf("Status : %d%n", response.statusCode());
        System.out.printf("Created: %s%n", response.body());
    }
}
