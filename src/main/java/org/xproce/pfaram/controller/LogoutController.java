package org.xproce.pfaram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xproce.pfaram.Classes.User;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        User.clearCurrentUser();
        return "redirect:/login";
    }
}