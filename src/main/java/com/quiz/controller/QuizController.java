package com.quiz.controller;

import com.quiz.dto.QuestionDto;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizQuestions(@PathVariable("id") int id){
        List<QuestionDto> dtoList = this.quizService.getQuizQuestions(id);
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
