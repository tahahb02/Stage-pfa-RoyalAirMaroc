package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xproce.pfaram.entity.PieceDemande;

@Repository
public interface PieceDemandeRepository extends JpaRepository<PieceDemande, Long> {
}
