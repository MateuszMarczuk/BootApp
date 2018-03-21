package com.marczuk.controllers;

import com.marczuk.entity.User;
import com.marczuk.services.UserService;
import org.apache.coyote.http11.HeadersTooLargeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 21.03.2018.
 */

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "/registerForm";
        }
        if (userService.isUserPresent(user.getEmail())){
            model.addAttribute("exist", true);
            return "registerForm";
        }
        userService.createUser(user);
        return "/success";
    }

}
