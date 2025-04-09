package com.rami.chanteur;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
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

    @OneToMany(mappedBy = "hiphop", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Chanteur> chanteurs;
}