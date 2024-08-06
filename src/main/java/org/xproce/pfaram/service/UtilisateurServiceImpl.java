package org.xproce.pfaram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.pfaram.entity.Utilisateur;
import org.xproce.pfaram.repository.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurRepository userRepository;

    @Override
    public void saveUser(Utilisateur user) {
        userRepository.save(user);
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Utilisateur findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Utilisateur> getAllTechniciens() {
        return userRepository.findByRole("technicien");
    }
    @Override
    public void save(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
