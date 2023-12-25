package org.example.service;

import org.example.model.Quiz;
import org.example.repository.QuizRepository;
import org.example.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuizService {
    QuizRepository quizRepository;
    @Autowired
    public QuizService(QuizRepository quizRepository){
        this.quizRepository=quizRepository;
    }
    public List<Quiz> getAllQuizzes(){
        return quizRepository.findAll();
    }
    public Optional<Quiz> getQuizById(Long id){
        return quizRepository.findById(id);
    }

    public List<Quiz> findQuizzesByKeyword(String keyword) {
        return quizRepository.findQuizzesByKeyword(keyword);
    }
    public Quiz updateQuiz(Long quizId, Quiz updatedQuiz) {
        Optional<Quiz> optionalExistingQuiz = quizRepository.findById(quizId);
        if (optionalExistingQuiz.isPresent()) {
            Quiz existingQuiz = optionalExistingQuiz.get();
            existingQuiz.setName(updatedQuiz.getName());
            return quizRepository.save(existingQuiz);
        } else {
            throw new ResourceNotFoundException("Quiz not found with ID: " + quizId);
        }
    }
    public Quiz addQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
    public void deleteById(Long id){
        quizRepository.deleteById(id);
    }

}
