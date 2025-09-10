package com.quiz.serviceImpl;

import com.quiz.dto.QuestionDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;



    @Override
    public String createQuiz(String quizName, int noOfQuestions, String category) {

        Quiz quiz = new Quiz();
        quiz.setTitle(quizName);
        List<Questions> quizQuestions = quizRepository.findRandomQuestions(noOfQuestions, category);
        quiz.setQuestionList(quizQuestions);
        quizRepository.save(quiz);
        String msg = "Quiz created with id";
        return msg;
    }

    @Override
    public List<QuestionDto> getQuizQuestions(int id) {

        Quiz quiz = quizRepository.findById(id).get();
        List<Questions> questionsList = quiz.getQuestionList();
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Questions q : questionsList){
            QuestionDto dto = new QuestionDto(q.getId(), q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionDtoList.add(dto);
        }
        return questionDtoList;
    }
}
