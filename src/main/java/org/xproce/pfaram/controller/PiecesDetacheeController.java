package org.xproce.pfaram.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.xproce.pfaram.entity.PiecesDetachee;
import org.xproce.pfaram.service.PiecesDetacheeService;

@Controller
@RequestMapping("/pieces")
public class PiecesDetacheeController {

    @Autowired
    private PiecesDetacheeService piecesDetacheeService;

    // Afficher la liste des pièces détachées
    @GetMapping
    public String listPieces(Model model) {
        model.addAttribute("pieces", piecesDetacheeService.getAllPieces());
        return "pieces"; // Redirige vers le template Thymeleaf 'pieces.html'
    }

    // Afficher le formulaire de création d'une pièce détachée
    @GetMapping("/new")
    public String createPieceForm(Model model) {
        model.addAttribute("piece", new PiecesDetachee());
        return "create_pieces"; // Redirige vers le template Thymeleaf 'create_pieces.html'
    }

    // Sauvegarder une nouvelle pièce détachée
    @PostMapping
    public String savePiece(@ModelAttribute("piece") PiecesDetachee piece) {
        piecesDetacheeService.savePiece(piece);
        return "redirect:/pieces"; // Redirige vers la liste des pièces après l'ajout
    }

    // Afficher le formulaire d'édition d'une pièce détachée
    @GetMapping("/edit/{id}")
    public String editPieceForm(@PathVariable int id, Model model) {
        PiecesDetachee piece = piecesDetacheeService.getPieceById(id);
        if (piece != null) {
            model.addAttribute("piece", piece);
            return "edit_pieces"; // Redirige vers le template Thymeleaf 'edit_pieces.html'
        } else {
            return "redirect:/pieces"; // Redirige vers la liste si la pièce n'est pas trouvée
        }
    }

    @PostMapping("/edit/{id}")
    public String updatePiece(@PathVariable int id, @ModelAttribute("piece") PiecesDetachee piece) {
        // Retrieve the existing piece from the database
        PiecesDetachee existingPiece = piecesDetacheeService.getPieceById(id);

        if (existingPiece != null) {
            existingPiece.setName(piece.getName());
            existingPiece.setDescription(piece.getDescription());
            existingPiece.setPrice(piece.getPrice());
            existingPiece.setQuantity(piece.getQuantity());

            piecesDetacheeService.updatePiece(existingPiece);
        }

        return "redirect:/pieces"; // Redirect to the list of pieces after the update
    }

    // Supprimer une pièce détachée
    @GetMapping("/delete/{id}")
    public String deletePiece(@PathVariable int id) {
        piecesDetacheeService.deletePieceById(id);
        return "redirect:/pieces"; // Redirige vers la liste des pièces après la suppression
    }
}
