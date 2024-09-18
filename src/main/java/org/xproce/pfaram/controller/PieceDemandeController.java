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
import org.xproce.pfaram.entity.PiecesDetachee;
import org.xproce.pfaram.service.PieceDemandeService;
import org.xproce.pfaram.service.PiecesDetacheeService;
import org.xproce.pfaram.service.PiecesDetacheeServiceImpl;

@Controller
public class PieceDemandeController {

    @Autowired
    private PieceDemandeService pieceDemandeService;
    @Autowired
    private PiecesDetacheeService piecesDetacheeService;

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
        if (User.isUserTechnician)
        {
            model.addAttribute("pieces", piecesDetacheeService.getAllPieces());
        }
        else {
            model.addAttribute("pieces", pieceDemandeService.findAllPieces());
        }

        return "techPieces";
    }


}
