package com.esi.mscommandscolarite.entities;

//import com.esi.msscolarite.model.Formation;
//import com.esi.msscolarite.model.Virement;
import com.esi.mscommandscolarite.model.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.EntityId;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Etudiant {

    @Id
    @EntityId
    @EqualsAndHashCode.Include
    private Long idEtudiant;

    private String nom;
    private Date dateN;
    private String promo;
    private Date dateInscription;

    @ManyToOne
    private Etablissement etablissement;

    @Transient
    private Formation formation;


  //  private Long idFormation;

     // @Transient
      //private Formation formation;

     // @Transient
    // List<Virement> virements;

}
