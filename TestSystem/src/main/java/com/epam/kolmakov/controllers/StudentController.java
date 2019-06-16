package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.*;
import com.epam.kolmakov.forms.AnswerLogForm;
import com.epam.kolmakov.services.AnswerLogService;
import com.epam.kolmakov.services.PassingTestService;
import com.epam.kolmakov.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes
public class StudentController {
    @Autowired
    private TestService testService;
    @Autowired
    private AnswerLogService answerLogService;
    @Autowired
    private PassingTestService passingTestService;

    @RequestMapping(value = "/student")
    public String getMainStudentForm(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("user");
        if (user != null && user.isAuthorized()) {
            if (user.getRole().equalsIgnoreCase("student")) {
                modelMap.addAttribute("user", user);
                return "mainStudent";
            }
        }
        return "redirect:/authorization";
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
            modelMap.addAttribute("counter",0);
            modelMap.addAttribute("test", test);
            return "passTest";
        }
        return "error";
    }

    @RequestMapping(value = "/passTest", method = RequestMethod.POST)
    public String takeTest(@ModelAttribute(name = "questionForm") AnswerLogForm answerLogForm, HttpSession session, ModelMap modelMap) {
        List<Answer> answers = answerLogForm.getAnswers();
        Long testId = answerLogForm.getTestId();
        if (answers != null) {
            for (Answer answer : answers) {
                AnswerLog answerLog = new AnswerLog(answer.getAnswerId(), answer.isChecked());
                answerLogService.saveAnswerLog(answerLog);
            }
        }
        User user = (User) session.getAttribute("user");
        PassingTest passingTest = new PassingTest();
        passingTest.setTestId(testId);
        if (user != null) {
            Long userId = user.getId();
            passingTest.setUserId(userId);
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
