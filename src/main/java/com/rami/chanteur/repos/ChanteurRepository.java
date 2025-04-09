package com.rami.chanteur.repos;

import com.rami.chanteur.Chanteur;
import com.rami.chanteur.Hiphop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface ChanteurRepository extends JpaRepository<Chanteur, Long> {
    List<Chanteur> findByNomChanteur(String nom);
    List<Chanteur> findByNomChanteurContains(String nom);

    @Query("select c from Chanteur c where c.nomChanteur like %:nom and c.cachetChanteur > :cachet")
    List<Chanteur> findByNomCachet(@Param("nom") String nom, @Param("cachet") Double cachet);

    @Query("select c from Chanteur c where c.hiphop = :hiphop")
    List<Chanteur> findByHiphop(@Param("hiphop") Hiphop hiphop);

    List<Chanteur> findByHiphopIdHiphop(Long id);

    List<Chanteur> findByOrderByNomChanteurAsc();

    @Query("select c from Chanteur c order by c.nomChanteur ASC, c.cachetChanteur DESC")
    List<Chanteur> trierChanteursNomCachet();
}