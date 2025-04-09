package com.rami.chanteur.service;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.Hiphop;
import java.util.List;

public interface ChanteurService {
    Chanteur saveChanteur(Chanteur c);
    Chanteur updateChanteur(Chanteur c);
    void deleteChanteur(Chanteur c);
    void deleteChanteurById(Long id);
    Chanteur getChanteur(Long id);
    List<Chanteur> getAllChanteurs();
    List<Chanteur> findByNomChanteur(String nom);
    List<Chanteur> findByNomChanteurContains(String nom);
    List<Chanteur> findByNomCachet(String nom, Double cachet);
    List<Chanteur> findByHiphop(Hiphop hiphop);
    List<Chanteur> findByHiphopIdHiphop(Long id);
    List<Chanteur> findByOrderByNomChanteurAsc();
    List<Chanteur> trierChanteursNomCachet();
}