package com.marczuk.controllers;

import com.marczuk.entity.User;
import com.marczuk.services.TaskService;
import com.marczuk.services.UserService;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 22.03.2018.
 */
@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfilePage(Model model, Principal principal){
        String email = principal.getName();
        User user = userService.findOneByEmail(email);
        model.addAttribute("tasks", taskService.findUserTask(user));
        return "/profile";
    }

}
