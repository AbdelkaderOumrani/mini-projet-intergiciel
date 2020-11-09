package com.esi.msqueryview.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantViewE {


    @Id
    private Long idEtudiant;
    private String nomEtablissement;
    private String nom;

}
