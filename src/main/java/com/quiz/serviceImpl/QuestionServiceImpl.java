package com.quiz.serviceImpl;

import com.quiz.entity.Questions;
import com.quiz.repository.QuestionRepository;
import com.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Questions> getAllQuestions() {
        List<Questions> questionsList = this.questionRepository.findAll();
        return questionsList;
    }
}
