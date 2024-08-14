package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xproce.pfaram.entity.Rapport;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long> {
}
