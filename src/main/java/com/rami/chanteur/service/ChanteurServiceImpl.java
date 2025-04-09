package com.rami.chanteur.service;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.Hiphop;
import com.rami.chanteur.repos.ChanteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChanteurServiceImpl implements ChanteurService {
    @Autowired
    private ChanteurRepository chanteurRepository;

    @Override
    public Chanteur saveChanteur(Chanteur c) {
        return chanteurRepository.save(c);
    }

    @Override
    public Chanteur updateChanteur(Chanteur c) {
        return chanteurRepository.save(c);
    }

    @Override
    public void deleteChanteur(Chanteur c) {
        chanteurRepository.delete(c);
    }

    @Override
    public void deleteChanteurById(Long id) {
        chanteurRepository.deleteById(id);
    }

    @Override
    public Chanteur getChanteur(Long id) {
        return chanteurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chanteur> getAllChanteurs() {
        return chanteurRepository.findAll();
    }

    @Override
    public List<Chanteur> findByNomChanteur(String nom) {
        return chanteurRepository.findByNomChanteur(nom);
    }

    @Override
    public List<Chanteur> findByNomChanteurContains(String nom) {
        return chanteurRepository.findByNomChanteurContains(nom);
    }

    @Override
    public List<Chanteur> findByNomCachet(String nom, Double cachet) {
        return chanteurRepository.findByNomCachet(nom, cachet);
    }

    @Override
    public List<Chanteur> findByHiphop(Hiphop hiphop) {
        return chanteurRepository.findByHiphop(hiphop);
    }

    @Override
    public List<Chanteur> findByHiphopIdHiphop(Long id) {
        return chanteurRepository.findByHiphopIdHiphop(id);
    }

    @Override
    public List<Chanteur> findByOrderByNomChanteurAsc() {
        return chanteurRepository.findByOrderByNomChanteurAsc();
    }

    @Override
    public List<Chanteur> trierChanteursNomCachet() {
        return chanteurRepository.trierChanteursNomCachet();
    }
}