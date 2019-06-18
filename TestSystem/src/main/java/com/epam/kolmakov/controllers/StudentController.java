package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.*;
import com.epam.kolmakov.forms.AnswerLogForm;
import com.epam.kolmakov.services.AnswerLogService;
import com.epam.kolmakov.services.PassingTestService;
import com.epam.kolmakov.services.SubjectService;
import com.epam.kolmakov.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private TestService testService;
    @Autowired
    private AnswerLogService answerLogService;
    @Autowired
    private PassingTestService passingTestService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/mainStudent")
    public String getMainStudentForm(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");
        modelMap.addAttribute("user", user);
        return "mainStudent";
    }

    @RequestMapping(value = "/selectTest")
    public String selectTest(ModelMap modelMap, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Test> availableTests = testService.getNotPassedTestByUser(user);
            modelMap.addAttribute("tests", availableTests);
            modelMap.addAttribute("selectTest", "true");
            return "mainStudent";
        }
        return "error";
    }

    @RequestMapping(value = "/takeTest")
    public String getTest(@RequestParam(name = "selectedTest") Long testId, ModelMap modelMap) {
        Optional<Test> optionalTest = testService.getTestById(testId);
        if (optionalTest.isPresent()) {
            Test test = optionalTest.get();
            modelMap.addAttribute("counter", -1);
            modelMap.addAttribute("test", test);
            return "passTest";
        }
        return "error";
    }

    @RequestMapping(value = "/takeTestList")
    public String getTestList(@RequestParam(name = "selectedSubject") Long subjectId, ModelMap modelMap) {
        Optional<Subject> optionalSubject = subjectService.getSubjectById(subjectId);
        List<Test> tests = new ArrayList<>();
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            tests = testService.getTestsBySubjectName(subject.getName());
            for (Test test : tests) {
                test.setSubject(subject);
            }
        }
        modelMap.addAttribute("tests", tests);
        modelMap.addAttribute("selectTest", "true");
        return "mainStudent";
    }

    @RequestMapping(value = "/takeSubjects")
    public String getSubjects(ModelMap modelMap) {
        List<Subject> subjects = subjectService.getAllSubjects();
        modelMap.addAttribute("subjects", subjects);
        modelMap.addAttribute("selectSubject", "true");
        return "mainStudent";
    }

    @RequestMapping(value = "/passTest")
    public String takeTest(@ModelAttribute(name = "answerLogForm") AnswerLogForm answerLogForm, String t, HttpSession session, ModelMap modelMap) {
        modelMap.addAttribute("answerLogForm", answerLogForm);
        List<Answer> answerList = answerLogForm.getAnswers();
        List<Answer> answers = new ArrayList<>();

        //some of answers have null-fields. They have to be removed
        for (Answer answer : answerList) {
            if (answer.getAnswerId() != null) {
                answers.add(answer);
            }
        }
        Long testId = answerLogForm.getTestId();
        Optional<Test> optionalTest = testService.getTestById(testId);
        User user = (User) session.getAttribute("user");

        for (Answer answer : answers) {
            AnswerLog answerLog = new AnswerLog(answer.getAnswerId(), answer.isChecked());
            answerLogService.saveAnswerLog(answerLog);
        }

        PassingTest passingTest = new PassingTest();
        passingTest.setAnswers(answers);
        passingTest.setTestId(testId);
        if (user != null) {
            Long userId = user.getId();
            passingTest.setUserId(userId);
        }
        if (optionalTest.isPresent()) {
            Test test = optionalTest.get();
            passingTest.setTest(test);
            Map<String, Short> result = passingTestService.getTestResult(passingTest);
            passingTest.setRightQuestionsAmount(result.get("right"));
            passingTest.setWrongQuestionsAmount(result.get("wrong"));

            modelMap.addAttribute("rightQuestions", result.get("right"));
            modelMap.addAttribute("commonQuestions", test.getQuestions().size());
        }

        if (passingTestService.save(passingTest)) {
            modelMap.addAttribute("testSaved", "true");
            return "mainStudent";
        } else {
            modelMap.addAttribute("testSaved", "false");
            return "mainStudent";
        }
    }
}
