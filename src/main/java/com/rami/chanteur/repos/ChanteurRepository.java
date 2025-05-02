package com.rami.chanteur.repos;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.Hiphop;
import com.rami.chanteur.dto.HiphopDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface ChanteurRepository extends JpaRepository<Chanteur, Long> {

    List<Chanteur> findByNomChanteur(String nom);
    List<Chanteur> findByNomChanteurContains(String nom);

    @Query("SELECT c FROM Chanteur c WHERE c.nomChanteur LIKE %?1% AND c.cachetChanteur = ?2")
    List<Chanteur> findByNomCachet(String nom, Double cachet);

    @Query("SELECT c FROM Chanteur c WHERE c.hiphop = ?1")
    List<Chanteur> findByHiphop(HiphopDTO hiphop);

    List<Chanteur> findByHiphopIdHiphop(Long id);

    List<Chanteur> findByOrderByNomChanteurAsc();

    @Query("SELECT c FROM Chanteur c ORDER BY c.nomChanteur ASC, c.cachetChanteur DESC")
    List<Chanteur> trierChanteursNomsCachets();
}