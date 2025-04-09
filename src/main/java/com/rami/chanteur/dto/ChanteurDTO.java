package com.rami.chanteur.dto;

import java.util.Date;

public class ChanteurDTO {
    private Long idChanteur;
    private String nomChanteur;
    private Double cachetChanteur;
    private Date dateDebut;
    private HiphopDTO hiphop;

    public ChanteurDTO() {}

    public ChanteurDTO(Long idChanteur, String nomChanteur, Double cachetChanteur, Date dateDebut, HiphopDTO hiphop) {
        this.idChanteur = idChanteur;
        this.nomChanteur = nomChanteur;
        this.cachetChanteur = cachetChanteur;
        this.dateDebut = dateDebut;
        this.hiphop = hiphop;
    }

    public Long getIdChanteur() {
        return idChanteur;
    }

    public void setIdChanteur(Long idChanteur) {
        this.idChanteur = idChanteur;
    }

    public String getNomChanteur() {
        return nomChanteur;
    }

    public void setNomChanteur(String nomChanteur) {
        this.nomChanteur = nomChanteur;
    }

    public Double getCachetChanteur() {
        return cachetChanteur;
    }

    public void setCachetChanteur(Double cachetChanteur) {
        this.cachetChanteur = cachetChanteur;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public HiphopDTO getHiphop() {
        return hiphop;
    }

    public void setHiphop(HiphopDTO hiphop) {
        this.hiphop = hiphop;
    }
}