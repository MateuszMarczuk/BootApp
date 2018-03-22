package com.marczuk.controllers;

import com.marczuk.entity.Task;
import com.marczuk.services.TaskService;
import com.marczuk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Mateusz Marczuk
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 21.03.2018.
 */
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public String taskForm(String email, Model model, HttpSession httpSession){
        httpSession.setAttribute("email", email);
        model.addAttribute("task", new Task());
        return "/taskForm";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession httpSession){
        if (bindingResult.hasErrors()){
            return "/taskForm";
        }
        String email = (String) httpSession.getAttribute("email");
        taskService.addTask(task, userService.findOneByEmail(email));

        return "redirect:/users";
    }

}

