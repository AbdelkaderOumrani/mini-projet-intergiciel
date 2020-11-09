package com.esi.coreapi.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddEtudiantComplet {
    @TargetAggregateIdentifier
    private String idFormation;
    private Long idEtudiant;
    private String nom;
    private String nomEtablissment;
    private Date dateN;
    //private String idEtablissement;
    private String promo;
    private Date dateInscription;

}
