package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.PiecesDetachee;
import org.xproce.pfaram.service.PiecesDetacheeService;

@Controller
public class HomeController {

    @GetMapping("/home_sup")
    public String homeSup() {
        return "home_sup"; // Ensure this matches the name of your Thymeleaf template
    }

    @GetMapping("/home_tech")
    public String homeTech() {
        return "home_tech"; // Ensure this matches the name of your Thymeleaf template
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }
}