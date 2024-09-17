package org.xproce.pfaram.service;

import org.xproce.pfaram.entity.Planing;

import java.util.List;

public interface PlaningService {

    List<Planing> getAllPlanings();

    Planing getPlaningById(int id);

    void savePlaning(Planing planing);

    void updatePlaning(Planing planing);

    void deletePlaningById(int id);
}
