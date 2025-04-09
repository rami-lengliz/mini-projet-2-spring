package com.rami.chanteur;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chanteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChanteur;

    private String nomChanteur;
    private Double cachetChanteur;
    private Date dateDebut;

    @ManyToOne
    @JoinColumn(name = "hiphop_id")
    @JsonBackReference
    private Hiphop hiphop;
}