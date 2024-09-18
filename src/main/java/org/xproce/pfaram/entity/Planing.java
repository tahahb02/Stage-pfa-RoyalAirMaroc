package org.xproce.pfaram.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public LocalDateTime getDatePlaning() {
        return datePlaning;
    }

    public void setDatePlaning(LocalDateTime datePlaning) {
        this.datePlaning = datePlaning;
    }

    public String getEtatDeplaning() {
        return etatDeplaning;
    }

    public void setEtatDeplaning(String etatDeplaning) {
        this.etatDeplaning = etatDeplaning;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomDeTechnicien;
    private String avion;
    private String objectif;
    private String description;


    private String etatDeplaning;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) // ISO 8601 format
    private LocalDateTime datePlaning; // Changed from Date to LocalDateTime


}