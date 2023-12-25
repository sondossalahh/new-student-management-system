package org.example.repository;

import org.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAll();
    Optional<Course> findById(Long id);
    List<Course> findByName(String name);
    Course save(Course course);
    void deleteById(Long id);
}
