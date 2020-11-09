package com.esi.coreapi.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtudiantAddedEventEtab {


    private Long idEtudiant;
    private String nomEtablissement;
    private String nom;

}
