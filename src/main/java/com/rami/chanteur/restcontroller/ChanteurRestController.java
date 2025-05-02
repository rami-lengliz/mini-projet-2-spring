 package com.rami.chanteur.restcontroller;

import com.rami.chanteur.dto.ChanteurDTO;
import com.rami.chanteur.dto.HiphopDTO;
import com.rami.chanteur.Chanteur;
import com.rami.chanteur.service.ChanteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ChanteurRestController {

    @Autowired
    ChanteurService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<ChanteurDTO> getAllChanteurs() {
        return service.getAllChanteurs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChanteurDTO getChanteurById(@PathVariable("id") Long id) {
        return service.getChanteur(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ChanteurDTO createChanteur(@RequestBody ChanteurDTO chanteur) {
        return service.saveChanteur(chanteur);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ChanteurDTO updateChanteur(@RequestBody ChanteurDTO chanteur) {
        return service.updateChanteur(chanteur);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChanteur(@PathVariable("id") Long id) {
        service.deleteChanteurById(id);
    }

    @RequestMapping(value = "/hiphop/{idHiphop}", method = RequestMethod.GET)
    public List<ChanteurDTO> getChanteursByHiphopId(@PathVariable("idHiphop") Long idHiphop) {
        return service.findByHiphopIdHiphop(idHiphop).stream()
                .map(chanteur -> {
                    ChanteurDTO dto = new ChanteurDTO();
                    dto.setIdChanteur(chanteur.getIdChanteur());
                    dto.setNomChanteur(chanteur.getNomChanteur());
                    dto.setCachetChanteur(chanteur.getCachetChanteur());
                    dto.setDateDebut(chanteur.getDateDebut());
                    HiphopDTO hiphopDTO = new HiphopDTO();
                    hiphopDTO.setIdHiphop(chanteur.getHiphop().getIdHiphop());
                    hiphopDTO.setNomHiphop(chanteur.getHiphop().getNomHiphop());
                    hiphopDTO.setDescriptionHiphop(chanteur.getHiphop().getDescriptionHiphop());
                    dto.setHiphop(hiphopDTO);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}