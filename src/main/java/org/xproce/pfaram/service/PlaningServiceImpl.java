package org.xproce.pfaram.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xproce.pfaram.entity.Planing;
import org.xproce.pfaram.repository.PlaningRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaningServiceImpl implements PlaningService {

    @Autowired
    private PlaningRepository planingRepository;

    @Override
    public List<Planing> getAllPlanings() {
        return planingRepository.findAll();
    }

    @Override
    public Planing getPlaningById(int id) {
        Optional<Planing> optionalAvion = planingRepository.findById(id);
        return optionalAvion.orElse(null);
    }

    @Override
    public void savePlaning(Planing planing) {
        planingRepository.save(planing);
    }

    @Override
    public void updatePlaning(Planing planing) {
        planingRepository.save(planing);
    }
    @Override
    public void deletePlaningById(int id) {
        planingRepository.deleteById(id);
    }
}
