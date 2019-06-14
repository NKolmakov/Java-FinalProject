package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.User;
import com.epam.kolmakov.forms.CreateTestForm;
import com.epam.kolmakov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class TutorController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/tutor")
    public String getMainTutorForm(HttpSession session){
        User user = (User)session.getAttribute("user");
        if (user != null && user.isAuthorized()) {
            if (user.getRole().equalsIgnoreCase("tutor")) {
                return "mainTutor";
            }
        }
        return "redirect:/authorization";
    }

    @RequestMapping(value = "/createTest")
    public String getCreateTestPage(){
        return "createTest";
    }

    @RequestMapping(value = "/saveTest",method = RequestMethod.POST)
    public String return2MainTutorPage(@ModelAttribute(name = "createTestForm") CreateTestForm createTestForm){
        return "mainTutor";
    }
}
