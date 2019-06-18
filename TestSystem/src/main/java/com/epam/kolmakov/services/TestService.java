package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.answer.AnswerDao;
import com.epam.kolmakov.db.dao.question.QuestionDao;
import com.epam.kolmakov.db.dao.questionList.QuestionListDao;
import com.epam.kolmakov.db.dao.test.TestDao;
import com.epam.kolmakov.db.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
     *
     * @param test - needed to save test
     * @return true if all test object was saved successfully, otherwise return false
     */
    public boolean saveTest(Test test) {
        Long savedTestId = testDaoImpl.saveAndGetId(test);
        if (savedTestId != -1) {
            for (Question question : test.getQuestions()) {
                Long savedQuestionId = questionDao.saveAndGetId(question);
                if (savedQuestionId != -1) {
                    for (Answer answer : question.getAnswers()) {
                        answer.setQuestionId(savedQuestionId);
                        answerDao.save(answer);
                    }
                } else {
                    return false;
                }

                questionListDao.save(new QuestionList(savedTestId, savedQuestionId));
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * <p>Method to get test from database. It returns test as object with it's questions and answers</p>
     *
     * @param id - test identifier
     * @return <i>Optional test</i> with it's questions and answers or <i>Optional.empty</i> if no test exists
     */
    public Optional<Test> getTestById(Long id) {
        Optional<Test> optionalTest = testDaoImpl.findById(id);
        if (optionalTest.isPresent()) {
            Test test = optionalTest.get();
            List<Question> questions = questionDao.getQuestionsByTestId(id);

            //for each found question look for questions
            for (Question question : questions) {
                List<Answer> answers = answerDao.getAnswersByQuestionId(question.getId());

                //if questions exist check quantity of right answers
                byte rightAnsAmount = 0;
                for (int i = 0; i < answers.size(); i++) {
                    if (rightAnsAmount <= 1) {
                        if (answers.get(i).isRight()) {
                            rightAnsAmount++;
                        }
                    } else {
                        //kind of break for current loop
                        i = answers.size();
                        question.setManyRightAnswers(true);
                    }
                }
                question.setAnswers(answers);
            }
            test.setQuestions(questions);
            return Optional.of(test);
        }
        return Optional.empty();
    }

    public List<Test> getNotPassedTestByUser(User user) {
        //list of tests which have questions and answers
        List<Test> ready2PassTests = new ArrayList<>();

        //loop with tests form database which don't have any answers and questions
        for (Test test : testDaoImpl.getNotPassedTestsByUserId(user.getId())) {
            Optional<Test> optionalTest = getTestById(test.getId());
            if (optionalTest.isPresent()){
                ready2PassTests.add(optionalTest.get());
            }
        }
        return ready2PassTests;
    }

    public List<Test> getTestsBySubjectName(String name){
        List<Test> testListFromDb = testDaoImpl.getTestsBySubjectName(name);
        List<Test> filledTests = new ArrayList<>();
        for (Test test:testListFromDb){
            Optional<Test> optionalTest = getTestById(test.getId());
            if(optionalTest.isPresent()){
                filledTests.add(optionalTest.get());
            }
        }
        return filledTests;
    }


}
