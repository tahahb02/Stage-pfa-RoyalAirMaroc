package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.Avion;
import org.xproce.pfaram.service.AvionService;

@Controller
@RequestMapping("/avions")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping
    public String listAvions(Model model) {
        model.addAttribute("avions", avionService.getAllAvions());
        return "avions"; // Redirige vers le template Thymeleaf 'avions.html'
    }

    @GetMapping("/superviseur")
    public String listAvionsSup(Model model) {
        model.addAttribute("avions", avionService.getAllAvions());
        return "voirAvionsSup"; // Redirige vers le template Thymeleaf 'avions.html'
    }

    @GetMapping("/new")
    public String createAvionForm(Model model) {
        model.addAttribute("avion", new Avion());
        return "create_avion"; // Redirige vers le template Thymeleaf 'create_avion.html'
    }

    @PostMapping
    public String saveAvion(@ModelAttribute("avion") Avion avion) {
        avionService.saveAvion(avion);
        return "redirect:/avions"; // Redirige vers la liste des avions après l'ajout
    }

    @GetMapping("/edit/{id}")
    public String editAvionForm(@PathVariable int id, Model model) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            model.addAttribute("avion", avion);
            return "edit_avion"; // Redirige vers le template Thymeleaf 'edit_avion.html'
        } else {
            return "redirect:/avions"; // Redirige vers la liste si l'avion n'est pas trouvé
        }
    }

    @PostMapping("/edit/{id}")
    public String updateAvion(@PathVariable int id, @ModelAttribute("avion") Avion avion) {
        // Retrieve the existing piece from the database
        Avion existingAvion = avionService.getAvionById(id);

        if (existingAvion != null) {
            existingAvion.setNom(avion.getNom());
            existingAvion.setCapacite(avion.getCapacite());
            existingAvion.setEtat(avion.getEtat());
            existingAvion.setType(avion.getType());

            avionService.updateAvion(existingAvion);
        }

        return "redirect:/avions";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvion(@PathVariable int id) {
        avionService.deleteAvionById(id);
        return "redirect:/avions"; // Redirige vers la liste des avions après la suppression
    }

    @GetMapping("/reparer/{id}")
    public String reparerAvion(@PathVariable int id) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            avion.setEtat("reparer");
            avionService.updateAvion(avion);
        }
        return "redirect:/avions"; // Redirige vers la liste des avions après la mise à jour de l'état
    }

    @GetMapping("/encoursdereparation/{id}")
    public String encoursdereparationAvion(@PathVariable int id) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            avion.setEtat("en_cours_de_reparation");
            avionService.updateAvion(avion);
        }
        return "redirect:/avions"; // Redirige vers la liste des avions après la mise à jour de l'état
    }

    @GetMapping("/irreparable/{id}")
    public String irreparableAvion(@PathVariable int id) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            avion.setEtat("irreparable");
            avionService.updateAvion(avion);
        }
        return "redirect:/avions"; // Redirige vers la liste des avions après la mise à jour de l'état
    }
}
