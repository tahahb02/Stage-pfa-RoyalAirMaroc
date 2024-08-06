package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Utilisateur;
import org.xproce.pfaram.service.UtilisateurService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/listTechniciens")
public class TechnicienController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/listTechniciens")
    public String listTechniciens(Model model) {
        model.addAttribute("techniciens", utilisateurService.getAllTechniciens());
        return "listTechniciens"; // Matches the Thymeleaf template 'listTechniciens.html'
    }

    @GetMapping("/listTechniciens/new")
    public String showNewTechnicienForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "new_technicien"; // Matches the Thymeleaf template 'new_technicien.html'
    }

    @PostMapping("/listTechniciens")
    public String saveTechnicien(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
        utilisateur.setRole("technicien");
        utilisateurService.save(utilisateur);
        return "redirect:/listTechniciens";
    }

    @GetMapping("/listTechniciens/edit/{id}")
    public String showEditTechnicienForm(@PathVariable("id") Long id, Model model) {
        Utilisateur utilisateur = utilisateurService.findById(id);
        model.addAttribute("utilisateur", utilisateur);
        return "edit_technicien"; // Create a template for editing if needed
    }

    @GetMapping("/listTechniciens/delete/{id}")
    public String deleteTechnicien(@PathVariable("id") Long id) {
        utilisateurService.deleteById(id);
        return "redirect:/listTechniciens";
    }
}
