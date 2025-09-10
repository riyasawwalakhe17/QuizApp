package com.quiz.service;

import com.quiz.dto.QuestionDto;

import java.util.List;

public interface QuizService {

    String createQuiz(String quizName, int noOfQuestions, String category);

    List<QuestionDto> getQuizQuestions(int id);


}
