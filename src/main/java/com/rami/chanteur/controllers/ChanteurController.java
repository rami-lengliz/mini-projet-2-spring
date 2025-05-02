package com.rami.chanteur.controllers;

import com.rami.chanteur.dto.ChanteurDTO;
import com.rami.chanteur.dto.HiphopDTO;
import com.rami.chanteur.service.ChanteurService;
import com.rami.chanteur.service.HiphopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChanteurController {

    @Autowired
    ChanteurService chanteurService;

    @Autowired
    HiphopService hiphopService;

    @RequestMapping("/ListeChanteur")
    public String listeChanteurs(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size) {
        Page<ChanteurDTO> chanteurs = chanteurService.getAllChanteursParPage(page, size);
        modelMap.addAttribute("chanteurs", chanteurs);
        int totalPages = chanteurs.getTotalPages();
        int[] pages = new int[totalPages];
        for (int i = 0; i < totalPages; i++) {
            pages[i] = i;
        }
        modelMap.addAttribute("pages", pages);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeChanteur";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("chanteur", new ChanteurDTO());
        modelMap.addAttribute("mode", "new");
        List<HiphopDTO> hiphops = hiphopService.getAllHiphops();
        if (hiphops.isEmpty()) {
            modelMap.addAttribute("error", "No hiphop categories available.");
        }
        modelMap.addAttribute("hiphops", hiphops);
        return "formChanteur";
    }

    @RequestMapping("/saveChanteur")
    public String saveChanteur(@Valid @ModelAttribute("chanteur") ChanteurDTO chanteurDTO,
                               BindingResult bindingResult,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "4") int size,
                               ModelMap modelMap) {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) {
            List<HiphopDTO> hiphops = hiphopService.getAllHiphops();
            modelMap.addAttribute("hiphops", hiphops);
            modelMap.addAttribute("mode", chanteurDTO.getIdChanteur() == null ? "new" : "edit");
            return "formChanteur";
        }

        if (chanteurDTO.getIdChanteur() == null) {
            isNew = true;
        }

        chanteurService.saveChanteur(chanteurDTO);

        if (isNew) {
            Page<ChanteurDTO> chanteurs = chanteurService.getAllChanteursParPage(page, size);
            currentPage = chanteurs.getTotalPages() - 1;
        } else {
            currentPage = page;
        }
        return "redirect:/ListeChanteur?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerChanteur")
    public String supprimerChanteur(@RequestParam("id") Long id,
                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(name = "size", defaultValue = "4") int size) {
        chanteurService.deleteChanteurById(id);
        return "redirect:/ListeChanteur?page=" + page + "&size=" + size;
    }

    @RequestMapping("/modifierChanteur")
    public String editerChanteur(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size) {
        ChanteurDTO chanteurDTO = chanteurService.getChanteur(id);
        modelMap.addAttribute("chanteur", chanteurDTO);
        modelMap.addAttribute("mode", "edit");
        List<HiphopDTO> hiphops = hiphopService.getAllHiphops();
        modelMap.addAttribute("hiphops", hiphops);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formChanteur";
    }

    @RequestMapping("/updateChanteur")
    public String updateChanteur(@Valid @ModelAttribute("chanteur") ChanteurDTO chanteurDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size,
                                 ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<HiphopDTO> hiphops = hiphopService.getAllHiphops();
            modelMap.addAttribute("hiphops", hiphops);
            modelMap.addAttribute("mode", "edit");
            return "formChanteur";
        }
        chanteurService.updateChanteur(chanteurDTO);
        return "redirect:/ListeChanteur?page=" + page + "&size=" + size;
    }
}