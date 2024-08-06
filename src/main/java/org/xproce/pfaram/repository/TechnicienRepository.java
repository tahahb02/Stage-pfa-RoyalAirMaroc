package org.xproce.pfaram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.pfaram.entity.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    // Define custom query methods if needed
}
