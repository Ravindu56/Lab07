package lk.ac.jfn.ec9590.server;

import lk.ac.jfn.ec9590.server.model.Student;
import lk.ac.jfn.ec9590.server.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository repo;

    public DataLoader(StudentRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) {
        repo.save(new Student("Alice Perera",      "alice@eng.jfn.ac.lk",    "Computer Engineering"));
        repo.save(new Student("Bob Silva",         "bob@eng.jfn.ac.lk",      "Electrical Engineering"));
        repo.save(new Student("Chathura Raj",      "chathura@eng.jfn.ac.lk", "Civil Engineering"));
        repo.save(new Student("Dilani Fernando",   "dilani@eng.jfn.ac.lk",   "Mechanical Engineering"));
        repo.save(new Student("Eranga Kamal",      "eranga@eng.jfn.ac.lk",   "Computer Engineering"));
        repo.save(new Student("Fathima Nazar",     "fathima@eng.jfn.ac.lk",  "Electronic Engineering"));
        repo.save(new Student("Gayan Mendis",      "gayan@eng.jfn.ac.lk",    "Computer Engineering"));
        repo.save(new Student("Hiruni Bandara",    "hiruni@eng.jfn.ac.lk",   "Civil Engineering"));
        repo.save(new Student("Isuru Jayasena",    "isuru@eng.jfn.ac.lk",    "Electrical Engineering"));
        repo.save(new Student("Janaki Weerasinghe","janaki@eng.jfn.ac.lk",   "Computer Engineering"));
    }
}
