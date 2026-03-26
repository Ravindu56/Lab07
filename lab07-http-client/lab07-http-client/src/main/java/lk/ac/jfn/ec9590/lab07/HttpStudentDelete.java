package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentDelete extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentDelete demo = new HttpStudentDelete();
        var client  = demo.httpClient();

        // d. Delete student with regNo=3
        int regNo = 3;
        var request  = demo.httpRequestDELETE(regNo);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("=== Task 01(d): Delete Student ===");
        System.out.printf("Status: %d%n", response.statusCode());
        if (response.statusCode() == 204) {
            System.out.printf("Student RegNo %d deleted successfully.%n", regNo);
        } else {
            System.out.println("Delete failed: " + response.body());
        }
    }
}
