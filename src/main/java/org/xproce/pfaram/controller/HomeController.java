package org.xproce.pfaram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.Classes.User;


@Controller
public class HomeController {

    @GetMapping("/home_sup")
    public String homeSup() {
        return dashboardChooserHelper();
    }

    @GetMapping("/home_tech")
    public String homeTech() {

        return dashboardChooserHelper();
    }

    @GetMapping("/")
    public String redirectToLogin() {

        return "redirect:/login";
    }

    public String dashboardChooserHelper()
    {
        if(User.isUserLoggedIn)
        {
            if(User.isUserTechnician) return "home_tech";
            else return "home_sup";
        }
        else return "/login";
    }

}