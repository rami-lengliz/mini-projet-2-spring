package com.rami.chanteur.service;

import com.rami.chanteur.Hiphop;
import java.util.List;

public interface HiphopService {
    Hiphop saveHiphop(Hiphop h);
    Hiphop updateHiphop(Hiphop h);
    void deleteHiphop(Hiphop h);
    void deleteHiphopById(Long id);
    Hiphop getHiphop(Long id);
    List<Hiphop> getAllHiphops();
}