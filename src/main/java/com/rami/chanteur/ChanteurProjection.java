package com.rami.chanteur;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomChanteur", types = { Chanteur.class })
public interface ChanteurProjection {
    String getNomChanteur();
}