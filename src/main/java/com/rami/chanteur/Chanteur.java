package com.rami.chanteur;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chanteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChanteur;
    private Double cachetChanteur; 
    private Date dateDebut;
	private String nomChanteur; 

    public Chanteur() {
        super();
    }

    public Chanteur(String nomChanteur, Double cachetChanteur, Date dateDebut) {
        super();
        this.nomChanteur = nomChanteur;
        this.cachetChanteur = cachetChanteur;
        this.dateDebut = dateDebut;
    }

    public Long getIdChanteur() { return idChanteur; }
    public void setIdChanteur(Long idChanteur) { this.idChanteur = idChanteur; }
    public String getNomChanteur() { return nomChanteur; }
    public void setNomChanteur(String nomChanteur) { this.nomChanteur = nomChanteur; }
    public Double getCachetChanteur() { return cachetChanteur; }
    public void setCachetChanteur(Double cachetChanteur) { this.cachetChanteur = cachetChanteur; }
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }

    @Override
    public String toString() {
        return "Chanteur [idChanteur=" + idChanteur + ", nomChanteur=" + nomChanteur + 
               ", cachetChanteur=" + cachetChanteur + ", dateDebut=" + dateDebut + "]";
    }
}