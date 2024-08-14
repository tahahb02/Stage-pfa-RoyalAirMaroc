package org.xproce.pfaram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.Classes.User;


@Controller
public class HomeController {

    @GetMapping("/home_sup")
    public String homeSup() {
        if(User.isUserSupervisor) return "home_sup";
        else return "home_tech";
    }

    @GetMapping("/home_tech")
    public String homeTech() {

        if(User.isUserTechnician) return "home_tech";
        else return "home_sup";
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }
}