package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.Question;
import com.epam.kolmakov.db.models.Test;
import com.epam.kolmakov.db.models.User;
import com.epam.kolmakov.forms.AnswerLogForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@SessionAttributes
public class StudentController {

    @RequestMapping(value = "/student")
    public String getMainStudentForm(HttpSession session,ModelMap modelMap){
        User user = (User)session.getAttribute("user");
        if (user != null && user.isAuthorized()) {
            if (user.getRole().equalsIgnoreCase("student")) {
                modelMap.addAttribute("user",user);
                return "mainStudent";
            }
        }
        return "redirect:/authorization";
    }

    @RequestMapping(value = "/selectTest")
    public String selectTest(ModelMap modelMap){
        //todo:fill
        List<Test> tests = new ArrayList<>();
        List<Question> questions = new LinkedList<>();
        questions.add(new Question(1L,"text"));
        tests.add(new Test(1L,"test to check test","desription",questions));
        tests.add(new Test(2L,"test to check test2","desription",questions));
        modelMap.addAttribute("tests",tests);
        modelMap.addAttribute("passTest","true");
        return "mainStudent";
    }

    @RequestMapping(value = "/passTest")
    public String getTest(ModelMap modelMap){
        List<Question> questions = new LinkedList<>();
        
        return "passTest";
    }

    @RequestMapping(value = "/takeTest",method = RequestMethod.POST)
    public String takeTest(@ModelAttribute(name = "questionForm") AnswerLogForm answerLogForm){
        System.out.println();
        return "mainStudent";
    }

    @RequestMapping(value = "/takeTest",method = RequestMethod.GET)
    public String fillTestBlank(ModelMap modelMap){
        List<Question> questions = new LinkedList<>();
        List<Answer> answers = new LinkedList<>();
        answers.add(new Answer(1L,"someans1",false));
        answers.add(new Answer(2L,"someans2",false));
        answers.add(new Answer(3L,"someans3",true));
        answers.add(new Answer(4L,"someans4",false));

        List<Answer> answers2 = new LinkedList<>();
        answers2.add(new Answer(1L,"ANSWER1",true));
        answers2.add(new Answer(2L,"ANSWER2",false));
        answers2.add(new Answer(3L,"ANSWER3",false));
        answers2.add(new Answer(4L,"ANSWER4",false));

        List<Answer> answers3 = new LinkedList<>();
        answers3.add(new Answer(1L,"ans1",true));
        answers3.add(new Answer(2L,"ans2",false));
        answers3.add(new Answer(3L,"ans3",false));
        answers3.add(new Answer(4L,"ans4",false));

        questions.add(new Question(1L,"text",answers));
        questions.add(new Question(2L,"text2",answers2));
        questions.add(new Question(3L,"text3",answers3));
        modelMap.addAttribute("questions",questions);
        return "passTest";
    }
}
