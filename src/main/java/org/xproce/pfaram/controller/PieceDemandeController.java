package org.xproce.pfaram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xproce.pfaram.Classes.User;
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
        return "newPieceDemande";
    }

    // Method to handle form submission and save the piece
    @PostMapping("/piece/request/new")
    public String savePiece(@ModelAttribute("piece") PieceDemande pieceDemande) {
        pieceDemandeService.savePieceDemande(pieceDemande);
        return "redirect:/home_tech?message=success";
    }

    // TechPieces
    @GetMapping("/techPieces")
    public String getTechPieces(Model model)
    {
        model.addAttribute("pieces", pieceDemandeService.findAllPieces());
        return "techPieces";
    }

    // TODO : L3entiz d taha, eafak matnsash tdir page wehdakhra dyal techPieces, ou smiah smiay mqada a si zb, ou mli dirh dir hadik if else l user ok bb ? lvy <3 mouah a777777


}
