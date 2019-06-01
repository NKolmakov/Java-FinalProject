package com.epam.kolmakov.controllers;

import com.epam.kolmakov.config.WebConfig;
import com.epam.kolmakov.db.models.Student;
import com.epam.kolmakov.forms.StudentForm;
import com.epam.kolmakov.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST)
    public String signUp(StudentForm studentForm, ModelMap modelMap) {
        Student student = Student.from(studentForm);
        try {
            studentService.saveStudent(student);
        }catch (Exception ex){
            WebConfig.LOGGER.error(ex.getStackTrace());
            return "error";
        }
        return "login";
    }
}
