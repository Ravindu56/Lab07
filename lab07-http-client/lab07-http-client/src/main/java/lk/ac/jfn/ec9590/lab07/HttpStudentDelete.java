package lk.ac.jfn.ec9590.lab07;

import java.io.IOException;
import java.net.http.HttpResponse;

public class HttpStudentDelete extends HttpStudentClientMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStudentDelete demo = new HttpStudentDelete();
        var client  = demo.httpClient();

        int regNo = 3;  // RegNo of the student to delete
        var request  = demo.httpRequestDELETE(regNo);
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.printf("Status: %s%n", response.statusCode());
        if (response.statusCode() == 204) {
            System.out.printf("Student RegNo %d deleted successfully.%n", regNo);
        } else {
            System.out.println("Delete failed: " + response.body());
        }
    }
}