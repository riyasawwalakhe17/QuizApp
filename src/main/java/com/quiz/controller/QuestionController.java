package com.quiz.controller;

import com.quiz.entity.Questions;
import com.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        List<Questions> questionsList = this.questionService.getAllQuestions();
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }



}
