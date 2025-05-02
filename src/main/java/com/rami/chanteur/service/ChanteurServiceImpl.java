package com.rami.chanteur.service;

import com.rami.chanteur.dto.ChanteurDTO;
import com.rami.chanteur.dto.HiphopDTO;
import com.rami.chanteur.Chanteur;
import com.rami.chanteur.Hiphop;
import com.rami.chanteur.repos.ChanteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChanteurServiceImpl implements ChanteurService {

    @Autowired
    ChanteurRepository repo;

    @Autowired
    HiphopService hiphopService;

    @Override
    public ChanteurDTO saveChanteur(ChanteurDTO chanteurDTO) {
        Chanteur chanteur = convertToEntity(chanteurDTO);
        chanteur = repo.save(chanteur);
        return convertToDTO(chanteur);
    }

    @Override
    public ChanteurDTO updateChanteur(ChanteurDTO chanteurDTO) {
        Chanteur chanteur = convertToEntity(chanteurDTO);
        Chanteur updatedChanteur = repo.save(chanteur);
        return convertToDTO(updatedChanteur);
    }

    @Override
    public void deleteChanteurById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public ChanteurDTO getChanteur(Long id) {
        Chanteur chanteur = repo.findById(id).orElseThrow(() -> new RuntimeException("Chanteur not found with id: " + id));
        return convertToDTO(chanteur);
    }

    @Override
    public List<ChanteurDTO> getAllChanteurs() {
        return repo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Page<ChanteurDTO> getAllChanteursParPage(int page, int size) {
        Page<Chanteur> chanteurPage = repo.findAll(PageRequest.of(page, size));
        return chanteurPage.map(this::convertToDTO);
    }

    @Override
    public List<ChanteurDTO> findByNomChanteur(String nom) {
        return repo.findByNomChanteur(nom).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> findByNomChanteurContains(String nom) {
        return repo.findByNomChanteurContains(nom).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> findByNomCachet(String nom, Double cachet) {
        return repo.findByNomCachet(nom, cachet).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> findByHiphop(HiphopDTO hiphopDTO) {
        HiphopDTO hiphop = hiphopService.getHiphop(hiphopDTO.getIdHiphop());
        return repo.findByHiphop(hiphop).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> findByHiphopIdHiphop(Long id) {
        return repo.findByHiphopIdHiphop(id).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> findByOrderByNomChanteurAsc() {
        return repo.findByOrderByNomChanteurAsc().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ChanteurDTO> trierChanteursNomsCachets() {
        return repo.trierChanteursNomsCachets().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ChanteurDTO convertToDTO(Chanteur chanteur) {
        ChanteurDTO dto = new ChanteurDTO();
        dto.setIdChanteur(chanteur.getIdChanteur());
        dto.setNomChanteur(chanteur.getNomChanteur());
        dto.setCachetChanteur(chanteur.getCachetChanteur());
        dto.setDateDebut(chanteur.getDateDebut());
        dto.setHiphop(convertToHiphopDTO(chanteur.getHiphop()));
        return dto;
    }

    private HiphopDTO convertToHiphopDTO(Hiphop hiphop) {
        if (hiphop == null) return null;
        HiphopDTO dto = new HiphopDTO();
        dto.setIdHiphop(hiphop.getIdHiphop());
        dto.setNomHiphop(hiphop.getNomHiphop());
        dto.setDescriptionHiphop(hiphop.getDescriptionHiphop());
        return dto;
    }


    private Hiphop convertHiphopDTOToEntity(HiphopDTO hiphopDTO) {
        if (hiphopDTO == null) {
            return null;
        }
        Hiphop hiphop = new Hiphop();
        hiphop.setIdHiphop(hiphopDTO.getIdHiphop());
        hiphop.setNomHiphop(hiphopDTO.getNomHiphop());
        hiphop.setDescriptionHiphop(hiphopDTO.getDescriptionHiphop());
        return hiphop;
    }
    private Chanteur convertToEntity(ChanteurDTO chanteurDTO) {
        Chanteur chanteur = new Chanteur();
        chanteur.setIdChanteur(chanteurDTO.getIdChanteur());
        chanteur.setNomChanteur(chanteurDTO.getNomChanteur());
        chanteur.setCachetChanteur(chanteurDTO.getCachetChanteur());
        chanteur.setDateDebut(chanteurDTO.getDateDebut());
        chanteur.setHiphop(convertHiphopDTOToEntity(chanteurDTO.getHiphop())); // Convert HiphopDTO to Hiphop
        return chanteur;
    }
    
}
