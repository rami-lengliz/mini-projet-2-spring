package com.rami.chanteur;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rami.chanteur.repos.ChanteurRepository;

@SpringBootTest
class ChanteursApplicationTests {
    @Autowired
    private ChanteurRepository chanteurRepository;

    @Test
    void testCreateChanteur() {
        Chanteur chanteur = new Chanteur("Ed Sheeran", 50000.0, new Date());
        chanteurRepository.save(chanteur);
    }

    @Test
    void testDeleteChanteur() {
        chanteurRepository.deleteById(1L);
    }

    @Test
    void testListerTousChanteurs() {
        List<Chanteur> chanteurs = chanteurRepository.findAll();
        for (Chanteur c : chanteurs) {
            System.out.println(c);
        }
    }
}