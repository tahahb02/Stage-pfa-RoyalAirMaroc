package org.xproce.pfaram.service;

import org.xproce.pfaram.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    void saveUser(Utilisateur user);
    Utilisateur findByEmail(String email);
    Utilisateur findById(Long id); // Ajoutez cette méthode pour trouver un utilisateur par ID
    void deleteUserById(Long id);  // Ajoutez cette méthode pour supprimer un utilisateur par ID
    List<Utilisateur> getAllUsers(); // Ajoutez cette méthode pour obtenir tous les utilisateurs

    List<Utilisateur> getAllTechniciens() ;
    void save(Utilisateur utilisateur) ;
    void deleteById(Long id) ;
}
