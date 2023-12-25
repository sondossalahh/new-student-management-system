package org.example.repository;

import org.example.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll();
    List<Teacher> findByName(String name);
    Optional<Teacher> findById(Long id);
    Teacher save(Teacher teacher);
    void deleteById(Long id);

}
