package com.rami.chanteur.service;

import com.rami.chanteur.Hiphop;
import com.rami.chanteur.repos.HiphopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HiphopServiceImpl implements HiphopService {
    @Autowired
    private HiphopRepository hiphopRepository;

    @Override
    public Hiphop saveHiphop(Hiphop h) {
        return hiphopRepository.save(h);
    }

    @Override
    public Hiphop updateHiphop(Hiphop h) {
        return hiphopRepository.save(h);
    }

    @Override
    public void deleteHiphop(Hiphop h) {
        hiphopRepository.delete(h);
    }

    @Override
    public void deleteHiphopById(Long id) {
        hiphopRepository.deleteById(id);
    }

    @Override
    public Hiphop getHiphop(Long id) {
        return hiphopRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hiphop> getAllHiphops() {
        return hiphopRepository.findAll();
    }
}