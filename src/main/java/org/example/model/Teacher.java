package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Student> students;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
    @ManyToMany(mappedBy = "teachers")
    private List<Quiz> quizzes;

    public Teacher() {
    }

    public Teacher(Long id, String name, List<Student> students, List<Course> courses, List<Quiz> quizzes) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.courses = courses;
        this.quizzes = quizzes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
