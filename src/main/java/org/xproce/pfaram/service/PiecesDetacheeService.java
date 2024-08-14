package org.xproce.pfaram.service;

import java.util.List;
import org.xproce.pfaram.entity.PiecesDetachee;

public interface PiecesDetacheeService
{
    List<PiecesDetachee> getAllPieces();
    PiecesDetachee getPieceById(int id);
    PiecesDetachee savePiece(PiecesDetachee piece);
    PiecesDetachee updatePiece(PiecesDetachee piece);
    void deletePieceById(int id);
}
