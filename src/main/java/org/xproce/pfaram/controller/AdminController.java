package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Utilisateur;
import org.xproce.pfaram.service.UtilisateurService;

@Controller
@RequestMapping("/administration")
public class AdminController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Display the list of both techniciens and superviseurs
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", utilisateurService.getAllUsers()); // Fetch both techniciens and superviseurs
        return "list_users"; // Matches the Thymeleaf template 'list_users.html'
    }

    // Show form to add a new user (technicien or superviseur)
    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "add_user"; // Matches the Thymeleaf template 'add_user.html'
    }

    // Save new user (technicien or superviseur)
    @PostMapping
    public String saveUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateurService.save(utilisateur);
        return "redirect:/administration";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.findById(id); // Fetch the user by ID
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur); // Add the user to the model
            return "edit_user"; // Thymeleaf template 'edit_user.html'
        } else {
            return "redirect:/administration"; // Or another page if the user is not found
        }
    }

    // Update user (technicien or superviseur)
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateur.setId(id);
        utilisateurService.save(utilisateur);
        return "redirect:/administration";
    }

    // Delete user by id
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        utilisateurService.deleteById(id);
        return "redirect:/administration";
    }
}