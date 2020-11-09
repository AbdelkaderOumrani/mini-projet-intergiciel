package com.esi.mscommandscolarite.entities;


import com.esi.coreapi.command.*;
import com.esi.coreapi.event.EtablissmentCreatedEvent;
import com.esi.coreapi.event.EtudiantAddedEventEtab;

import com.esi.coreapi.event.EtudiantRemovedEvent;
import com.esi.coreapi.event.EtudiantRemovedEventEtab;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Aggregate
@Data @AllArgsConstructor @NoArgsConstructor
public class Etablissement {

    @Id
    @AggregateIdentifier
    private String idEtablissement;
    private String nom;

    @AggregateMember
    @JsonIgnore
    @OneToMany(mappedBy = "etablissement" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

   @CommandHandler
   public Etablissement(CreateEtablissmentCommand cmd){

       this.idEtablissement=cmd.getIdEtablissement();
       this.nom=cmd.getNom();
       this.etudiants=new ArrayList<>();


       AggregateLifecycle.apply(new EtablissmentCreatedEvent( cmd.getIdEtablissement(),
               cmd.getNom()));


    }

    @CommandHandler
    public void handle(AddEtudiantCommandEta cmd)
    {
        //consitency rules

        this.etudiants.add(new Etudiant(
                cmd.getIdEtudiant(),cmd.getNom(),cmd.getDateN(),cmd.getPromo(),cmd.getDateInscription(),this
        ,null));

        AggregateLifecycle.apply(new EtudiantAddedEventEtab(

                cmd.getIdEtudiant(),
                this.nom,
                cmd.getNom()

        ));



    }



    @CommandHandler
    public void handle(RemoveEtudiantCommandEta cmd, EtudiantRepository etudiantRepository)
    {
        //constraint
        Etudiant etudiant=new Etudiant();
        etudiant.setIdEtudiant(cmd.getIdEtudiant());
        this.etudiants.remove(etudiant);

        etudiantRepository.deleteById(cmd.getIdEtudiant());

        AggregateLifecycle.apply(new EtudiantRemovedEventEtab(cmd.getIdEtudiant()));

    }
}
