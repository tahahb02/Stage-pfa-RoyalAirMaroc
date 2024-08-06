package org.xproce.pfaram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.pfaram.entity.Technicien;
import org.xproce.pfaram.repository.TechnicienRepository;

import java.util.List;

@Service
public class TechnicienServiceImpl {

    @Autowired
    private TechnicienRepository technicienRepository;

    public List<Technicien> getAllTechniciens() {
        return technicienRepository.findAll();
    }

    public Technicien getTechnicienById(Long id) {
        return technicienRepository.findById(id).orElse(null);
    }

    public Technicien saveTechnicien(Technicien technicien) {
        return technicienRepository.save(technicien);
    }

    public void deleteTechnicienById(Long id) {
        technicienRepository.deleteById(id);
    }
}
