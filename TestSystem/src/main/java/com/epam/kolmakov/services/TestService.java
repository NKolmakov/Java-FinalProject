package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.answer.AnswerDao;
import com.epam.kolmakov.db.dao.question.QuestionDao;
import com.epam.kolmakov.db.dao.questionList.QuestionListDao;
import com.epam.kolmakov.db.dao.test.TestDao;
import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.Question;
import com.epam.kolmakov.db.models.QuestionList;
import com.epam.kolmakov.db.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestDao testDaoImpl;
    @Autowired
    private QuestionListDao questionListDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    /**
     * <p>Method allow save test including it's objects to database</p>
     * @param test - needed to save test
     * @return true if all test object was saved successfully, otherwise return false
     */
    public boolean saveTest(Test test) {
        Long savedTestId = testDaoImpl.saveAndGetId(test);
        if (savedTestId != -1) {
            for (Question question : test.getQuestions()) {
                Long savedQuestionId = questionDao.saveAndGetId(question);
                if(savedQuestionId != -1) {
                    for (Answer answer : question.getAnswers()) {
                        answer.setQuestionId(savedQuestionId);
                        answerDao.save(answer);
                    }
                }else{
                    return false;
                }

                questionListDao.save(new QuestionList(savedTestId, savedQuestionId));
            }
        }else{
            return false;
        }
        return true;
    }

    public Optional<Test> getTestById(Long id){
        return testDaoImpl.findById(id);
    }

    private Long saveAndGetGeneratedId(Test test){
        return testDaoImpl.saveAndGetId(test);
    }
}
