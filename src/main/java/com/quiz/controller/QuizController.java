package com.quiz.controller;

import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam int noOfQ,
                                             @RequestParam String quizName,
                                             @RequestParam String category){
        String msg = this.quizService.createQuiz(quizName,noOfQ,category);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
