package org.example.repository;

import org.example.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAll();
    @Query("SELECT q FROM Quiz q WHERE q.quizName LIKE %:keyword%")
    List<Quiz> findQuizzesByKeyword(@Param("keyword") String keyword);
    Optional<Quiz> findById(Long id);
    Quiz save(Quiz quiz);
    void deleteById(Long id);
}
