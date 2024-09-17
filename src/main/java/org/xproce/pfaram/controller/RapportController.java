package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.xproce.pfaram.entity.Rapport;
import org.xproce.pfaram.service.RapportService;

import org.xproce.pfaram.Classes.User;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RapportController {

    @Autowired
    private RapportService rapportService;

    @GetMapping("/mesRapports")
    public String mesRapports(Model model) {
        List<Rapport> rapports = rapportService.findAllRapports();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");

        Map<Long, String> formattedDates = new HashMap<>();

        for (Rapport rapport : rapports) {
            String formattedDate = rapport.getDateCreation().format(formatter);
            formattedDates.put(rapport.getId(), formattedDate);
        }

        model.addAttribute("formattedDates", formattedDates);
        model.addAttribute("rapports", rapports);

        if (User.isUserTechnician)
        {
            return "mesRapports";
        }
        else
        {
            return "listRapport";
        }
    }

    @GetMapping("/rapports/new")
    public String createRapportForm(Model model) {
        model.addAttribute("rapport", new Rapport());
        return "create_rapport";
    }

    @PostMapping("/mesRapports")
    public String saveRapport(Rapport rapport) {
        rapportService.saveRapport(rapport);
        return "redirect:/mesRapports";
    }

    @GetMapping("/rapports/{id}")
    public String viewRapportDetails(@PathVariable Long id, Model model) {
        Rapport rapport = rapportService.findRapportById(id);
        model.addAttribute("rapport", rapport);
        return "detailRapport";
    }


    @GetMapping("/listRapport")
    public String getSupRapports(Model model) {
        List<Rapport> rapports = rapportService.findAllRapports();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm");

        Map<Long, String> formattedDates = new HashMap<>();

        for (Rapport rapport : rapports) {
            String formattedDate = rapport.getDateCreation().format(formatter);
            formattedDates.put(rapport.getId(), formattedDate);
        }

        model.addAttribute("formattedDates", formattedDates);
        model.addAttribute("rapports", rapports);


        return "listRapport";
    }
}
