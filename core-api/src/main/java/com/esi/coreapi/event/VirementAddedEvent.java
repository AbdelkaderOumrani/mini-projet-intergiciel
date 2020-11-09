package com.esi.coreapi.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VirementAddedEvent {

    private String nom;
    // private String nomEtablissement ;
    private Float montant;
    private Date dateVirement;




}
