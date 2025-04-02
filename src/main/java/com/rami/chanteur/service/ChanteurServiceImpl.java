package com.rami.chanteur.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.rami.chanteur.Chanteur;
import com.rami.chanteur.repos.ChanteurRepository;

@Service
public class ChanteurServiceImpl implements ChanteurService {
    @Autowired
    private ChanteurRepository chanteurRepository;

    @Override
    public Chanteur saveChanteur(Chanteur c) {
        return chanteurRepository.save(c);
    }

    @Override
    public Chanteur updateChanteur(Chanteur c) {
        return chanteurRepository.save(c);
    }

    @Override
    public void deleteChanteur(Chanteur c) {
        chanteurRepository.delete(c);
    }

    @Override
    public void deleteChanteurById(Long id) {
        chanteurRepository.deleteById(id);
    }

    @Override
    public Chanteur getChanteur(Long id) {
        return chanteurRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chanteur> getAllChanteurs() {
        return chanteurRepository.findAll();  
    }

	@Override
	public Page<Chanteur> getAllChanteursParPage(int page, int size) {
		return chanteurRepository.findAll(PageRequest.of(page, size));
	}
}