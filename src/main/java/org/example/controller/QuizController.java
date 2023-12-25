package org.example.controller;

import org.example.model.Quiz;
import org.example.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }
    @GetMapping("/{quizId}")
    public Optional<Quiz> getQuizById(@PathVariable Long quizId) {
        return quizService.getQuizById(quizId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }
    @PutMapping("/{quizId}")
    public Quiz updateQuiz(@PathVariable Long quizId, @RequestBody Quiz updatedQuiz) {
        return quizService.updateQuiz(quizId, updatedQuiz);
    }
    @DeleteMapping("/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteById(quizId);
    }

}