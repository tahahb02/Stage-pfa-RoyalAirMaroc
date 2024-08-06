package org.xproce.pfaram.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Maintenance {
    @Id
    private String id;
    private String avionId;
    private String technicienId;
    private String description;
    private String etat;

    // Constructeurs, getters et setters
}
