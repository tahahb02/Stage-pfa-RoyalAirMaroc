package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Utilisateur;
import org.xproce.pfaram.service.UtilisateurServiceImpl;

@Controller
public class LoginController {

    @Autowired
    private UtilisateurServiceImpl userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Ensure this matches the name of your Thymeleaf template
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            @RequestParam String role,
                            Model model) {

        Utilisateur user = userService.findByEmail(email);

        // Check if user exists and password matches
        if (user != null && user.getMot_de_passe().equals(password)) { // For real applications, compare hashed passwords
            if (role.equalsIgnoreCase(user.getRole())) {
                if ("technicien".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/home_tech";
                } else if ("superviseur".equalsIgnoreCase(user.getRole())) {
                    return "redirect:/home_sup";
                }
            } else {
                model.addAttribute("error", "Role mismatch.");
                return "login"; // Redirect back to login page with error
            }
        }
        else {
            model.addAttribute("error", "Invalid email or password.");
            return "login"; // Redirect back to login page with error
        }
        return "login";
    }
}
