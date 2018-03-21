package com.marczuk.controllers;

import com.marczuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 21.03.2018.
 */
@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("users",userService.findByName(name));
        return "/users";
    }

}
