package com.rami.chanteur;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rami.chanteur.Chanteur;
import com.rami.chanteur.service.ChanteurService;

@SpringBootApplication
public class ChanteurApplication implements CommandLineRunner {
    @Autowired
    private ChanteurService chanteurService;

    public static void main(String[] args) {
        SpringApplication.run(ChanteurApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        chanteurService.saveChanteur(new Chanteur("Ed Sheeran", 50000.0, new Date()));
        chanteurService.saveChanteur(new Chanteur("Adele", 60000.0, new Date()));
        chanteurService.saveChanteur(new Chanteur("Bruno Mars", 45000.0, new Date()));
    }
}