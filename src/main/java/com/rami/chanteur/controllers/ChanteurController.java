package com.rami.chanteur.controllers;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.service.ChanteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChanteurController {
    @Autowired
    private ChanteurService chanteurService;

    @GetMapping("/chanteurs")
    public List<Chanteur> getAllChanteurs() {
        return chanteurService.getAllChanteurs();
    }

    @GetMapping("/chanteurs/{id}")
    public Chanteur getChanteurById(@PathVariable Long id) {
        return chanteurService.getChanteur(id);
    }

    @PostMapping("/chanteurs")
    public Chanteur createChanteur(@RequestBody Chanteur chanteur) {
        return chanteurService.saveChanteur(chanteur);
    }

    @PutMapping("/chanteurs")
    public Chanteur updateChanteur(@RequestBody Chanteur chanteur) {
        return chanteurService.updateChanteur(chanteur);
    }

    @DeleteMapping("/chanteurs/{id}")
    public void deleteChanteur(@PathVariable Long id) {
        chanteurService.deleteChanteurById(id);
    }

    @GetMapping("/chanteurs/byHiphop/{hiphopId}")
    public List<Chanteur> getChanteursByHiphopId(@PathVariable Long hiphopId) {
        return chanteurService.findByHiphopIdHiphop(hiphopId);
    }
}