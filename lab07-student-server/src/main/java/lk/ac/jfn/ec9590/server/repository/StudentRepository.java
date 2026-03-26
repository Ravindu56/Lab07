package lk.ac.jfn.ec9590.server.repository;

import lk.ac.jfn.ec9590.server.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}
