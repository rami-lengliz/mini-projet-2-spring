package com.rami.chanteur.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rami.chanteur.Chanteur;

public interface ChanteurRepository extends JpaRepository<Chanteur, Long> {
}