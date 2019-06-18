package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.passingTest.PassingTestDao;
import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.PassingTest;
import com.epam.kolmakov.db.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PassingTestService {
    @Autowired
    private PassingTestDao passingTestDao;

    public boolean save(PassingTest passingTest) {

        return passingTestDao.save(passingTest);
    }

    /**
     * <p>Method process passed test and return result as Map.</p>
     *
     * @param passingTest - object contains Users data from view
     * @return - Map<String,Short>.First key "right" show right checked answers amount.
     * Second key "wrong" show not right checked answers amount
     */
    public Map getTestResult(PassingTest passingTest) {
        List<Answer> userAnswers = new ArrayList<>();
        userAnswers.addAll(passingTest.getAnswers());

        List<Question> questions = new ArrayList<>();
        questions.addAll(passingTest.getTest().getQuestions());

        if (userAnswers.size() > 0) {
            Collections.sort(userAnswers, (o1, o2) -> {
                Long first = o1.getQuestionId();
                Long second = o2.getQuestionId();
                long res = first - second;
                return (int) res;
            });
        }
        if (questions.size() > 0) {
            Collections.sort(questions, (o1, o2) -> {
                Long first = o1.getId();
                Long second = o1.getId();
                long res = first - second;
                return (int) res;
            });
        }

        Short rightQuestionsAmount = 0;
        Short wrongQuestionsAmount = 0;
        for (Question question : passingTest.getTest().getQuestions()) {
            boolean right = true;
            for (int i = 0; i < question.getAnswers().size(); i++) {
                Answer rightAnswer = question.getAnswers().get(i);
                for (int j = 0; j < userAnswers.size(); j++) {
                    Answer userAnswer = userAnswers.get(j);
                    if (right && rightAnswer.getAnswerId() == userAnswer.getAnswerId()) {
                        if (!rightAnswer.isRight() == userAnswer.isChecked()) {
                            right = false;
                            wrongQuestionsAmount++;
                            //to break from loops
                            j = userAnswers.size();
                            i = question.getAnswers().size();
                        }
                    }
                }
            }
            if (right) {
                rightQuestionsAmount++;
            }
        }

        Map<String, Short> result = new HashMap<>();
        result.put("right", rightQuestionsAmount);
        result.put("wrong", wrongQuestionsAmount);
        return result;
    }

}
