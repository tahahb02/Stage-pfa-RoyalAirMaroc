package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xproce.pfaram.entity.PieceDemande;
import org.xproce.pfaram.service.PieceDemandeService;

@Controller
public class PieceDemandeController {

    @Autowired
    private PieceDemandeService pieceDemandeService;

    // Method to display the form for creating a new piece
    @GetMapping("/piece/request/new")
    public String showCreatePieceForm(Model model) {
        model.addAttribute("piece", new PieceDemande());
        return "newPieceDemande"; // Name of the Thymeleaf template
    }

    // Method to handle form submission and save the piece
    @PostMapping("/piece/request/new")
    public String savePiece(@ModelAttribute("piece") PieceDemande pieceDemande) {
        pieceDemandeService.savePieceDemande(pieceDemande);
        return "redirect:/home_tech?message=success";
    }

    // Method to display the list of pieces
    @GetMapping("/piece/request")
    public String listPieces(Model model) {
        model.addAttribute("pieces", pieceDemandeService.findAllPieces());
        return "demanderPiece"; // Name of the Thymeleaf template for listing pieces
    }
}
