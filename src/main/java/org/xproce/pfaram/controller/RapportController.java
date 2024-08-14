package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Rapport;
import org.xproce.pfaram.service.RapportService;

@Controller
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @GetMapping("/listRapport")
    public String listRapport() {
        return "listRapport";
    }
    @GetMapping("/rapports")
    public String rapports() {
        return "listRapport";
    }

    @GetMapping("/mesRapports")
    public String mesRapports() {
        return "mesRapports";
    }

    @GetMapping("/rapports/new")
    public String createRapportForm(Model model) {
        model.addAttribute("rapport", new Rapport());
        return "create_rapport"; // Nom du template Thymeleaf
    }

    @PostMapping("/mesRapports")
    public String saveRapport(@ModelAttribute("rapport") Rapport rapport) {
        rapportService.saveRapport(rapport);
        return "redirect:/mesRapports"; // Redirect after saving
    }
}
