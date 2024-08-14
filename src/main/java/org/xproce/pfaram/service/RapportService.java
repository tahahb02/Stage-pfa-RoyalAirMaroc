package org.xproce.pfaram.service;

import org.xproce.pfaram.entity.Rapport;

import java.util.List;

public interface RapportService {
    List<Rapport> findAllRapports();
    Rapport findRapportById(Long id);
    Rapport saveRapport(Rapport rapport);
    void deleteRapport(Long id);
}
