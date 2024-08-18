package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.xproce.pfaram.entity.Rapport;
import org.xproce.pfaram.service.RapportService;

import java.util.List;

@Controller
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @GetMapping("/mesRapports")
    public String mesRapports(Model model) {
        List<Rapport> rapports = rapportService.findAllRapports();
        model.addAttribute("rapports", rapports);
        return "mesRapports";
    }

    @GetMapping("/rapports/new")
    public String createRapportForm(Model model) {
        model.addAttribute("rapport", new Rapport());
        return "create_rapport";
    }

    @PostMapping("/rapports")
    public String saveRapport(Rapport rapport) {
        rapportService.saveRapport(rapport);
        return "redirect:/mesRapports";
    }

    // Méthode pour afficher les détails d'un rapport
    @GetMapping("/rapports/{id}")
    public String detailRapport(@PathVariable Long id, Model model) {
        Rapport rapport = rapportService.findRapportById(id);
        model.addAttribute("rapport", rapport);
        return "detail_rapport";
    }
}
