package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentPut extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentPut demo = new HttpStudentPut();
        var client = demo.httpClient();

        int regNo = 1;  // RegNo of the student whose email you want to update
        String json = """
                {
                  "email": "alice.updated@eng.jfn.ac.lk"
                }
                """;

        var request  = demo.getHttpRequestPUT(regNo, json);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.printf("Status : %s%n", response.statusCode());
        System.out.printf("Updated: %s%n", response.body());
    }
}