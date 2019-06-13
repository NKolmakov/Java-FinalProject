package com.epam.kolmakov.controllers;

import com.epam.kolmakov.db.models.Group;
import com.epam.kolmakov.db.models.User;
import com.epam.kolmakov.forms.UserForm;
import com.epam.kolmakov.services.GroupService;
import com.epam.kolmakov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AuthorizationController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration")
    public String getRegistrationForm(ModelMap modelMap) {
        List<Group> groups = groupService.getAllGroups();
        modelMap.addAttribute("groups", groups);
        return "registration";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String getAuthorizationForm() {
        return "authorization";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(UserForm userForm, ModelMap modelMap, HttpSession session) {
        User user = User.from(userForm);
        if (userService.isAuthorizationCorrect(user)) {
            User userFromDb = userService.getUserByLogin(user).get();
            session.setAttribute("user",userFromDb);
            if (userFromDb.getRole().equalsIgnoreCase("student")) {
                return "redirect:/student";
            } else if (userFromDb.getRole().equalsIgnoreCase("tutor")) {
                return "redirect:/tutor";
            }
        }
        return "authorization";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String singIn() {
        return "authorization";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String singUp(UserForm userForm, ModelMap modelMap) {
        User user = User.from(userForm);
        List<Group> groups = groupService.getAllGroups();
        modelMap.addAttribute("groups", groups);
        if (userService.saveUser(user)) {
            modelMap.addAttribute("error","false");
            return "registration";
        } else {
            modelMap.addAttribute("error","true");
            return "registration";
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String singUp(ModelMap modelMap) {
        List<Group> groups = groupService.getAllGroups();
        modelMap.addAttribute("groups", groups);
        return "registration";
    }

    @RequestMapping(value = "/403")
    public String getAccessDenied(){
        return "403";
    }
}
