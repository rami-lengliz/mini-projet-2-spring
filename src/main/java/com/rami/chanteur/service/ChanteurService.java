package com.rami.chanteur.service;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.dto.ChanteurDTO;
import com.rami.chanteur.dto.HiphopDTO;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import java.util.List;

public interface ChanteurService {
    ChanteurDTO saveChanteur(ChanteurDTO eminemDTO);
    ChanteurDTO updateChanteur(ChanteurDTO chanteurDTO);    void deleteChanteurById(Long id);
    ChanteurDTO getChanteur(Long id);
    List<ChanteurDTO> getAllChanteurs();
    Page<ChanteurDTO> getAllChanteursParPage(int page, int size);
    List<ChanteurDTO> findByNomChanteur(String nom);
    List<ChanteurDTO> findByNomChanteurContains(String nom);
    List<ChanteurDTO> findByNomCachet(String nom, Double cachet);
    List<ChanteurDTO> findByHiphop(HiphopDTO hiphopDTO);
    List<ChanteurDTO> findByHiphopIdHiphop(Long id);
    List<ChanteurDTO> findByOrderByNomChanteurAsc();
    List<ChanteurDTO> trierChanteursNomsCachets();
}