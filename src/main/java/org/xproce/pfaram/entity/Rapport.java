package org.xproce.pfaram.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rapport {
    @Id
    private String id;
    private String maintenanceId;
    private String description;
    private String date;

    // Constructeurs, getters et setters
}
