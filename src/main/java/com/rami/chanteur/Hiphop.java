package com.rami.chanteur;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hiphop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHiphop;

    private String nomHiphop;
    private String descriptionHiphop;

    @OneToMany(mappedBy = "hiphop")
    @JsonIgnore 
    
    private List<Chanteur> chanteurs = new ArrayList<>();

    public void addChanteur(Chanteur chanteur) {
        chanteurs.add(chanteur);
        chanteur.setHiphop(this);
    }
}