package com.rami.chanteur.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.rami.chanteur.Chanteur;

public interface ChanteurService {
    Chanteur saveChanteur(Chanteur c);
    Chanteur updateChanteur(Chanteur c);
    void deleteChanteur(Chanteur c);
    void deleteChanteurById(Long id);
    Chanteur getChanteur(Long id);
    List<Chanteur> getAllChanteurs();
    Page<Chanteur> getAllChanteursParPage(int page, int size);
}