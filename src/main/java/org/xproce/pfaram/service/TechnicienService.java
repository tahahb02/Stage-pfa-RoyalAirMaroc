package org.xproce.pfaram.service;

import org.xproce.pfaram.entity.Technicien;

import java.util.List;

public interface TechnicienService {
    List<Technicien> getAllTechniciens();
    Technicien getTechnicienById(Long id);
    Technicien saveTechnicien(Technicien technicien);
    void deleteTechnicienById(Long id);
}
