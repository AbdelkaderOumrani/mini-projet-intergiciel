package com.esi.coreapi.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtudiantAddedEventComplet {

    private String nomFormation;
    // private String nomEtablissement ;
    private Long idEtudiant;
    private String nom;
    private String nomEtablissement;

}
