package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentPost extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentPost demo = new HttpStudentPost();
        var client = demo.httpClient();

        String json = """
                {
                  "name": "Kasun Pathirana",
                  "email": "kasun@eng.jfn.ac.lk",
                  "department": "Computer Engineering"
                }
                """;

        var request  = demo.getHttpRequestPOST(json);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.printf("Status : %s%n", response.statusCode());
        System.out.printf("Created: %s%n", response.body());
    }
}