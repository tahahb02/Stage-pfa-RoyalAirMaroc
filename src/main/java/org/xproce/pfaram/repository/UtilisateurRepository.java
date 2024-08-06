package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.pfaram.entity.Utilisateur;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    List<Utilisateur> findByRole(String role);
}
