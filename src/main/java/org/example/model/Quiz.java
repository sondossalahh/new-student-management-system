package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "quizzes")
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @JoinTable(name = "quiz_teacher",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;

    public Quiz(){}

    public Quiz(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Quiz(Long id, String name, List<Student> students, Course course, List<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.course = course;
        this.teachers = teachers;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
