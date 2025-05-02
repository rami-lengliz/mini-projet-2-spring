package com.rami.chanteur;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import com.rami.chanteur.dto.HiphopDTO;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chanteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChanteur;

    @NotNull
	@Size (min = 4,max = 15)

    private String nomChanteur;

    @NotNull
	
    private Double cachetChanteur;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date must be in the past or present")
    private Date dateDebut;

    @ManyToOne
   
    private Hiphop hiphop;


    public Hiphop getHiphop()
    {
        return hiphop;

    }

    public void setHiphop( Hiphop hiphop)
    {
        this.hiphop=hiphop;

    }

    public Chanteur(@NotNull @Size(min = 4, max = 15) String nomChanteur, @NotNull Double cachetChanteur,
            @NotNull(message = "Start date cannot be null") @PastOrPresent(message = "Start date must be in the past or present") Date dateDebut,
            Hiphop hiphop) {
        this.nomChanteur = nomChanteur;
        this.cachetChanteur = cachetChanteur;
        this.dateDebut = dateDebut;
        this.hiphop = hiphop;
    }




    

}