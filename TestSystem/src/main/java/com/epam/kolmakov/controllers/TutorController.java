package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.*;
import com.epam.kolmakov.forms.CreateTestForm;
import com.epam.kolmakov.services.SubjectService;
import com.epam.kolmakov.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/tutor")
public class TutorController {
    @Autowired
    private TestService testService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/mainTutor")
    public String getMainTutorForm(HttpSession session, ModelMap modelMap){
        User user = (User) session.getAttribute("user");
        modelMap.addAttribute("user",user);
        return "mainTutor";
    }

    @RequestMapping(value = "/createTest")
    public String getCreateTestPage(){
        return "createTest";
    }

    @RequestMapping(value = "/saveTest",method = RequestMethod.POST)
    public String return2MainTutorPage(@ModelAttribute(name = "createTestForm") CreateTestForm createTestForm,ModelMap modelMap){
        Test test = new Test(createTestForm.getTestName(),createTestForm.getTestDescription());
        test.setQuestions(createTestForm.getQuestions());
        for (Question question:test.getQuestions()){
            List<Answer> answers = new ArrayList<>();
            for (Answer answer:createTestForm.getAnswersByQuestionNumber(question.getNumber())){
                answers.add(answer);
            }
            question.setAnswers(answers);
        }
        Subject subject = new Subject(createTestForm.getSubjectName());
        Long subjectId = subjectService.saveAndGetId(subject);
        test.setSubjectId(subjectId);
        Optional<Subject> optionalSubject = subjectService.getSubjectById(test.getSubjectId());
        if(optionalSubject.isPresent()){
            test.setSubject(optionalSubject.get());
        }
        if(testService.saveTest(test)) {
            modelMap.addAttribute("save","true");
        }else{
            modelMap.addAttribute("save","false");
        }
        return "mainTutor";
    }
}
