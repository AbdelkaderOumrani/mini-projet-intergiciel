package com.esi.msqueryview.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantCompletView {


    @Id
    private Long idEtudiant;
    private String nom;
    private String nomFormation;
    private String nomEtablissement;
   // private List<String> montant ;
}
