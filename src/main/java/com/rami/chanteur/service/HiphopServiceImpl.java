package com.rami.chanteur.service;

import com.rami.chanteur.dto.HiphopDTO;
import com.rami.chanteur.Hiphop;
import com.rami.chanteur.repos.HiphopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HiphopServiceImpl implements HiphopService {

    @Autowired
    private HiphopRepository hiphopRepository;

    @Override
    public HiphopDTO saveHiphop(HiphopDTO hiphopDTO) {
        Hiphop hiphop = convertToEntity(hiphopDTO);
        hiphop = hiphopRepository.save(hiphop);
        return convertToDTO(hiphop);
    }

    @Override
    public HiphopDTO updateHiphop(HiphopDTO hiphopDTO) {
        Hiphop hiphop = convertToEntity(hiphopDTO);
        hiphop = hiphopRepository.save(hiphop);
        return convertToDTO(hiphop);
    }

    @Override
    public void deleteHiphopById(Long id) {
        hiphopRepository.deleteById(id);
    }

    @Override
    public HiphopDTO getHiphop(Long id) {
        Hiphop hiphop = hiphopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hiphop not found with id: " + id));
        return convertToDTO(hiphop);
    }

    @Override
    public List<HiphopDTO> getAllHiphops() {
        return hiphopRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private HiphopDTO convertToDTO(Hiphop hiphop) {
        if (hiphop == null) return null;
        HiphopDTO dto = new HiphopDTO();
        dto.setIdHiphop(hiphop.getIdHiphop());
        dto.setNomHiphop(hiphop.getNomHiphop());
        dto.setDescriptionHiphop(hiphop.getDescriptionHiphop());
        return dto;
    }

    private Hiphop convertToEntity(HiphopDTO dto) {
        if (dto == null) return null;
        Hiphop hiphop = new Hiphop();
        hiphop.setIdHiphop(dto.getIdHiphop());
        hiphop.setNomHiphop(dto.getNomHiphop());
        hiphop.setDescriptionHiphop(dto.getDescriptionHiphop());
        return hiphop;
    }
}