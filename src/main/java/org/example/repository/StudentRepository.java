package org.example.repository;
import org.example.model.Course;
import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findAll();
    List<Student> findByName(String name);
    Optional<Student> findById(Long id);
    @Query("SELECT s.courses FROM Student s WHERE s.id = :studentId")
    List<Course> getCoursesOfStudent(@Param("studentId") Long studentId);
    Student save(Student student);
    void deleteById(Long id);
}
