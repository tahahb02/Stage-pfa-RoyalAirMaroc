package org.xproce.pfaram.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.pfaram.entity.PiecesDetachee;
import org.xproce.pfaram.repository.PiecesDetacheeRepository;
import org.xproce.pfaram.service.PiecesDetacheeService;

import java.util.List;

@Service
public class PiecesDetacheeServiceImpl implements PiecesDetacheeService {

    @Autowired
    private PiecesDetacheeRepository piecesDetacheeRepository;

    @Override
    public List<PiecesDetachee> getAllPieces() {
        return piecesDetacheeRepository.findAll();
    }

    @Override
    public PiecesDetachee getPieceById(int id) {
        return piecesDetacheeRepository.findById(id).orElse(null);
    }

    @Override
    public PiecesDetachee savePiece(PiecesDetachee piece) {
        return piecesDetacheeRepository.save(piece);
    }

    @Override
    public PiecesDetachee updatePiece(PiecesDetachee piece) {
        return piecesDetacheeRepository.save(piece);
    }

    @Override
    public void deletePieceById(int id) {
        piecesDetacheeRepository.deleteById(id);
    }
}
