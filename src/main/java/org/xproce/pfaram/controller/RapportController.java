package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Rapport;
import org.xproce.pfaram.service.RapportService;

@Controller
@RequestMapping("/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @GetMapping("/listRapport")
    public String listRapport() {
        return "listRapport";
    }

    @GetMapping("/new")
    public String createRapportForm(Model model) {
        model.addAttribute("rapport", new Rapport());
        return "create_rapport"; // Nom du template Thymeleaf
    }

    @PostMapping
    public String saveRapport(@ModelAttribute("rapport") Rapport rapport) {
        rapportService.saveRapport(rapport);
        return "redirect:/rapports"; // Redirection après l'enregistrement
    }
}
