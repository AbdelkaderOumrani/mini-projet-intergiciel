package com.esi.coreapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class etudiantDTObourse {

    private Long idEtudiant;
    private Long nCompteCcp;
    private float SalaireParant;

}
