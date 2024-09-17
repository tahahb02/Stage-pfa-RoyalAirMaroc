package org.xproce.pfaram.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Planing {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDeTechnicien() {
        return nomDeTechnicien;
    }

    public void setNomDeTechnicien(String nomDeTechnicien) {
        this.nomDeTechnicien = nomDeTechnicien;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePlaning() {
        return datePlaning;
    }

    public void setDatePlaning(Date datePlaning) {
        this.datePlaning = datePlaning;
    }

    public String getEtatDeplaning() {
        return etatDeplaning;
    }

    public void setEtatDeplaning(String etatDeplaning) {
        this.etatDeplaning = etatDeplaning;
    }

    @PrePersist
    protected void onCreate() {
        datePlaning = new Date();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomDeTechnicien;
    private String avion;
    private String objectif;
    private String description;


    private String etatDeplaning;
    private Date datePlaning;


}