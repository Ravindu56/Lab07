package lk.ac.jfn.ec9590.server.controller;

import lk.ac.jfn.ec9590.server.model.Student;
import lk.ac.jfn.ec9590.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // a. GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // b. POST - create new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // c. PUT - update student email by regNo
    @PutMapping("/{regNo}")
    public ResponseEntity<Student> updateStudent(@PathVariable int regNo,
                                                  @RequestBody Student updated) {
        Optional<Student> opt = repo.findById(regNo);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        Student s = opt.get();
        s.setEmail(updated.getEmail());
        return ResponseEntity.ok(repo.save(s));
    }

    // d. DELETE - delete a student by regNo
    @DeleteMapping("/{regNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int regNo) {
        if (!repo.existsById(regNo)) return ResponseEntity.notFound().build();
        repo.deleteById(regNo);
        return ResponseEntity.noContent().build();
    }
}
