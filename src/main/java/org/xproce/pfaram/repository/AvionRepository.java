package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xproce.pfaram.entity.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
}
