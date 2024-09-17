package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xproce.pfaram.entity.Planing;

@Repository
public interface PlaningRepository extends JpaRepository<Planing, Integer> {
}