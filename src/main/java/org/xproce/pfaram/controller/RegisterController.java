package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Utilisateur;
import org.xproce.pfaram.service.UtilisateurServiceImpl;

@Controller
public class RegisterController {

    @Autowired
    private UtilisateurServiceImpl userService;

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String nom,
                               @RequestParam String prenom,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               @RequestParam String role,
                               Model model) {

        // Basic validation for password confirmation
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Les mots de passe ne correspondent pas.");
            return "register";
        }

        // Create and save the user
        Utilisateur user = new Utilisateur();
        user.setEmail(email);
        user.setMotDePasse(password); // For real applications, use a hashed password
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setRole(role);

        userService.saveUser(user);

        // Redirect to login page with success message
        return "redirect:/login?success";
    }
}
