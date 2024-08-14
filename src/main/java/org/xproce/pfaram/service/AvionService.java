package org.xproce.pfaram.service;

import org.xproce.pfaram.entity.Avion;

import java.util.List;

public interface AvionService {

    List<Avion> getAllAvions();

    Avion getAvionById(int id);

    void saveAvion(Avion avion);

    void updateAvion(Avion avion);

    void deleteAvionById(int id);
}
