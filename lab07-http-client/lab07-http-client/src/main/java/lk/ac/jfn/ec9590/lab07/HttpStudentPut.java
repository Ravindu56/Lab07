package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentPut extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentPut demo = new HttpStudentPut();
        var client = demo.httpClient();

        // c. Update email of student with regNo=1
        int regNo = 1;
        String json = """
                {
                  "email": "alice.updated@eng.jfn.ac.lk"
                }
                """;

        var request  = demo.getHttpRequestPUT(regNo, json);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("=== Task 01(c): Update Student Email ===");
        System.out.printf("Status : %d%n", response.statusCode());
        System.out.printf("Updated: %s%n", response.body());
    }
}
