package org.xproce.pfaram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.pfaram.entity.PieceDemande;
import org.xproce.pfaram.repository.PieceDemandeRepository;

import java.util.List;

@Service
public class PieceDemandeService {

    @Autowired
    private PieceDemandeRepository pieceDemandeRepository;

    // Save a new PieceDemande
    public void savePieceDemande(PieceDemande pieceDemande) {
        pieceDemandeRepository.save(pieceDemande);
    }

    // Retrieve all PieceDemande entities
    public List<PieceDemande> findAllPieces() {
        return pieceDemandeRepository.findAll();
    }
}
