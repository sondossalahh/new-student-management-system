package org.example.service;

import org.example.model.Course;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }
    public List<Student>getStudentsByName(String name){
        return studentRepository.findByName(name);
    }
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }
    public List<Course> getCoursesOfStudent(Long studentId) {
        return studentRepository.getCoursesOfStudent(studentId);
    }
    public Student updateStudent(Long studentId, Student updatedStudent){
        Optional<Student> optionalExistingStudent = getStudentById(studentId);
        if (optionalExistingStudent.isPresent()) {
            Student existingStudent = optionalExistingStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            return studentRepository.save(updatedStudent);
        } else {
            throw new ResourceNotFoundException("Student with ID not found "+studentId);
        }
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
