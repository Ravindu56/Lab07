package lk.ac.jfn.ec9590.server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regNo;
    private String name;
    private String email;
    private String department;

    public Student() {}

    public Student(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public int getRegNo()                        { return regNo; }
    public void setRegNo(int regNo)              { this.regNo = regNo; }
    public String getName()                      { return name; }
    public void setName(String name)             { this.name = name; }
    public String getEmail()                     { return email; }
    public void setEmail(String email)           { this.email = email; }
    public String getDepartment()                { return department; }
    public void setDepartment(String department) { this.department = department; }
}
