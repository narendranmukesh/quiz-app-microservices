package com.microservices.quizService.service;

import com.microservices.quizService.dao.QuizDao;
import com.microservices.quizService.feign.QuizInterface;
import com.microservices.quizService.model.QuestionWrapper;
import com.microservices.quizService.model.Quiz;
import com.microservices.quizService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> optionalQuiz = quizDao.findById(id);

        if (optionalQuiz.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Quiz quiz = optionalQuiz.get();
        List<Integer> questionIds = quiz.getQuestionIds();

        return quizInterface.getQuestionsFromId(questionIds);
    }

    public ResponseEntity<Integer> calculateResults(Integer id, List<Response> responses) {

        ResponseEntity<Integer> score =quizInterface.getScore(responses);
        return score;
    }
}
