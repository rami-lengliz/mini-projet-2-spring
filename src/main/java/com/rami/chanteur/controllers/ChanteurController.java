package com.rami.chanteur.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rami.chanteur.Chanteur; 
import com.rami.chanteur.service.ChanteurService; 

@Controller
public class ChanteurController {
    @Autowired
    private ChanteurService chanteurService;

    @RequestMapping("/ListeChanteurs")
    public String listeChanteurs(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Chanteur> chanteurs = chanteurService.getAllChanteursParPage(page, size);
        modelMap.addAttribute("chanteurs", chanteurs);
        modelMap.addAttribute("pages", new int[chanteurs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeChanteurs";
    }

    @RequestMapping("/supprimerChanteur")
    public String supprimerChanteur(@RequestParam("id") Long id, ModelMap modelMap,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "2") int size) {
        chanteurService.deleteChanteurById(id);
        Page<Chanteur> chanteurs = chanteurService.getAllChanteursParPage(page, size);
        modelMap.addAttribute("chanteurs", chanteurs);
        modelMap.addAttribute("pages", new int[chanteurs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeChanteurs";
    }

    @RequestMapping("/modifierChanteur")
    public String editerChanteur(@RequestParam("id") Long id, ModelMap modelMap) {
        Chanteur c = chanteurService.getChanteur(id);
        modelMap.addAttribute("chanteur", c);
        return "editerChanteur";
    }

    @RequestMapping("/updateChanteur")
    public String updateChanteur(@ModelAttribute("chanteur") Chanteur chanteur,
                                 @RequestParam("date") String date,
                                 ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = dateFormat.parse(date);
        chanteur.setDateDebut(dateDebut);
        chanteurService.updateChanteur(chanteur);
        Page<Chanteur> chanteurs = chanteurService.getAllChanteursParPage(0, 2); // Use pagination for consistency
        modelMap.addAttribute("chanteurs", chanteurs);
        modelMap.addAttribute("pages", new int[chanteurs.getTotalPages()]);
        modelMap.addAttribute("currentPage", 0);
        modelMap.addAttribute("size", 2);
        return "listeChanteurs";
    }

    // Add a test endpoint for debugging
    @RequestMapping("/test")
    public String test(ModelMap modelMap) {
        modelMap.addAttribute("message", "Controller is working!");
        return "test";
    }
}