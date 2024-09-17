package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Planing;
import org.xproce.pfaram.service.PlaningService;

@Controller
@RequestMapping("/planings")
public class PlaningController {

    @Autowired
    private PlaningService planingService;

    @GetMapping
    public String listPlanings(Model model) {
        model.addAttribute("planings", planingService.getAllPlanings());
        return "planings";
    }

    @GetMapping("/superviseur")
    public String listPlaningSup(Model model) {
        model.addAttribute("planings", planingService.getAllPlanings());
        return "voirPlaningsSup";
    }

    @GetMapping("/new")
    public String createPlaningForm(Model model) {
        model.addAttribute("planing", new Planing());
        return "create_planing";
    }

    @PostMapping
    public String savePlaning(@ModelAttribute("planing") Planing planing) {
        planingService.savePlaning(planing);
        return "redirect:/planings";
    }

    @GetMapping("/edit/{id}")
    public String editPlaningForm(@PathVariable int id, Model model) {
        Planing planing = planingService.getPlaningById(id);
        if (planing != null) {
            model.addAttribute("planing", planing);
            return "edit_planing";
        } else {
            return "redirect:/planings";
        }
    }

    @PostMapping("/edit/{id}")
    public String updatePlaning(@PathVariable int id, @ModelAttribute("planing") Planing planing)
    {
        Planing existingPlaning = planingService.getPlaningById(id);
        if (existingPlaning != null) {
            existingPlaning.setNomDeTechnicien(planing.getNomDeTechnicien());
            existingPlaning.setDescription(planing.getDescription());
            existingPlaning.setObjectif(planing.getObjectif());
            existingPlaning.setAvion(planing.getAvion());

            planingService.updatePlaning(existingPlaning);
        }

        return "redirect:/planing";
    }

    @GetMapping("/delete/{id}")
    public String deletePlaning(@PathVariable int id) {
        planingService.deletePlaningById(id);
        return "redirect:/planings";
    }

    @GetMapping("/accept/{id}")
    public String acceptPlaning(@PathVariable int id) {
        Planing planing = planingService.getPlaningById(id);
        if (planing != null) {
            planing.setEtatDeplaning("Accepte");
            planingService.updatePlaning(planing);
        }
        return "redirect:/planings";
    }

    @GetMapping("/refuse/{id}")
    public String refusePlaning(@PathVariable int id) {
        Planing planing = planingService.getPlaningById(id);
        if (planing != null) {
            planing.setEtatDeplaning("Refuse");
            planingService.updatePlaning(planing);
        }
        return "redirect:/planings";
    }

}
