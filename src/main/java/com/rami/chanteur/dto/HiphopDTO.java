package com.rami.chanteur.dto;

import java.util.List;

public class HiphopDTO {
    private Long idHiphop;
    private String nomHiphop;
    private String descriptionHiphop;
    private List<ChanteurDTO> chanteurs;

    public HiphopDTO() {}

    public HiphopDTO(Long idHiphop, String nomHiphop, String descriptionHiphop, List<ChanteurDTO> chanteurs) {
        this.idHiphop = idHiphop;
        this.nomHiphop = nomHiphop;
        this.descriptionHiphop = descriptionHiphop;
        this.chanteurs = chanteurs;
    }

    public Long getIdHiphop() {
        return idHiphop;
    }

    public void setIdHiphop(Long idHiphop) {
        this.idHiphop = idHiphop;
    }

    public String getNomHiphop() {
        return nomHiphop;
    }

    public void setNomHiphop(String nomHiphop) {
        this.nomHiphop = nomHiphop;
    }

    public String getDescriptionHiphop() {
        return descriptionHiphop;
    }

    public void setDescriptionHiphop(String descriptionHiphop) {
        this.descriptionHiphop = descriptionHiphop;
    }

    public List<ChanteurDTO> getChanteurs() {
        return chanteurs;
    }

    public void setChanteurs(List<ChanteurDTO> chanteurs) {
        this.chanteurs = chanteurs;
    }
}