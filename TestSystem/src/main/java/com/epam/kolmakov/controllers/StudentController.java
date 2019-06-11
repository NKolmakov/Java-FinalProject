package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.User;
import com.epam.kolmakov.forms.UserForm;
import com.epam.kolmakov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/student")
    public String getMainStudentForm(){
        return "mainStudent";
    }
}
