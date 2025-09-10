package com.quiz.serviceImpl;

import com.quiz.dto.QuestionDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import com.quiz.repository.QuestionRepository;
import com.quiz.repository.QuizRepository;
import com.quiz.request.QuizRequest;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository  questionRepository;

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

    @Override
    public String submitQuiz(List<QuizRequest> request, int quizId) {

        Quiz quiz = quizRepository.findById(quizId).get();
        List<Questions> questionListOfQuiz = quiz.getQuestionList();
        int correctAnswer = 0;
        for(Questions q:questionListOfQuiz){
            for(QuizRequest quizRequest :request ){
                if(quizRequest.getQId() == q.getId()){
                    if(quizRequest.getOptionSelect() == q.getCorrectOption()){
                        correctAnswer++;
                    }
                }
                else{
                    //question is not from Quiz
                }
            }
        }
        String msg = "Your score is : " + correctAnswer;

        return msg;
    }
}
