package org.xproce.pfaram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xproce.pfaram.entity.Avion;
import org.xproce.pfaram.repository.AvionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AvionServiceImpl implements AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Override
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }

    @Override
    public Avion getAvionById(Long id) {
        Optional<Avion> optionalAvion = avionRepository.findById(id);
        return optionalAvion.orElse(null);
    }

    @Override
    public void saveAvion(Avion avion) {
        avionRepository.save(avion);
    }

    @Override
    public void updateAvion(Avion avion) {
        avionRepository.save(avion); // La méthode save de JpaRepository gère à la fois l'ajout et la mise à jour
    }

    @Override
    public void deleteAvionById(Long id) {
        avionRepository.deleteById(id);
    }
}
