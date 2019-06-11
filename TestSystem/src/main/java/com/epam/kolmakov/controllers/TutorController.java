package com.epam.kolmakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorController {

    @RequestMapping(value = "/tutor")
    public String getMainTutorForm(){
        return "mainTutor";
    }
}
