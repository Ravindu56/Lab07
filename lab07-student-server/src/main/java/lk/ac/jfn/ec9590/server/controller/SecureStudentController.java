package lk.ac.jfn.ec9590.server.controller;

import lk.ac.jfn.ec9590.server.model.Student;
import lk.ac.jfn.ec9590.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/students/secure")
public class SecureStudentController {

    private static final String VALID_USERNAME = "student";
    private static final String VALID_PASSWORD = "password123";

    @Autowired
    private StudentRepository repo;

    @GetMapping("/{regNo}")
    public ResponseEntity<?> getSecureStudent(
            @PathVariable int regNo,
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        // Check Authorization header exists and starts with "Basic "
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Basic realm=\"StudentRealm\"")
                    .body("401 Unauthorized: Missing or invalid Authorization header");
        }

        // Decode Base64 credentials
        String base64Credentials = authHeader.substring("Basic ".length());
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        String[] parts = decoded.split(":", 2);

        if (parts.length != 2) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("401 Unauthorized: Malformed credentials");
        }

        String username = parts[0];
        String password = parts[1];

        // Verify credentials
        if (!VALID_USERNAME.equals(username) || !VALID_PASSWORD.equals(password)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Basic realm=\"StudentRealm\"")
                    .body("401 Unauthorized: Invalid username or password");
        }

        // Credentials valid - return student
        Optional<Student> student = repo.findById(regNo);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with RegNo " + regNo + " not found");
        }

        return ResponseEntity.ok(student.get());
    }
}
