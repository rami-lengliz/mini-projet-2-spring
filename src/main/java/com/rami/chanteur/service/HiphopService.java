package com.rami.chanteur.service;

import com.rami.chanteur.dto.HiphopDTO;
import java.util.List;

public interface HiphopService {
    HiphopDTO saveHiphop(HiphopDTO hiphopDTO);
    HiphopDTO updateHiphop(HiphopDTO hiphopDTO);
    void deleteHiphopById(Long id);
    HiphopDTO getHiphop(Long id);
    List<HiphopDTO> getAllHiphops();
}