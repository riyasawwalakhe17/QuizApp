package com.quiz.repository;

import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    @Query(value = "SELECT * FROM questions q WHERE q.category= :category ORDER BY RAND() LIMIT :noOfQuestions ",nativeQuery = true)
    List<Questions> findRandomQuestions(@Param("noOfQuestions") int noOfQuestions,@Param("category") String category);

}
