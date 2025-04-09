package com.rami.chanteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.rami.chanteur.repos.ChanteurRepository;
import com.rami.chanteur.repos.HiphopRepository;

import java.util.Date;

@SpringBootApplication
public class ChanteurApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private ChanteurRepository chanteurRepository;

    @Autowired
    private HiphopRepository hiphopRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChanteurApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Chanteur.class);
        repositoryRestConfiguration.exposeIdsFor(Hiphop.class);

        // Add test data
        Hiphop westCoast = new Hiphop(null, "West Coast", "West Coast hip-hop style", null);
        hiphopRepository.save(westCoast);

        Chanteur eminem = new Chanteur(null, "Eminem", 50000.0, new Date(), westCoast);
        chanteurRepository.save(eminem);
    }
}