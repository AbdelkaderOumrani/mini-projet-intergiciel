package com.example.commandbib.entities;

//import com.esi.msbourse.model.EtudiantScolarite;

import com.esi.coreapi.command.AddCartebibCommand;
import com.esi.coreapi.command.AddVirementCommand;
import com.esi.coreapi.command.RemouveCartebibCommand;
import com.esi.coreapi.command.RemoveVirementCommand;
import com.esi.coreapi.event.CartebibAddEvent;
import com.esi.coreapi.event.EtudiantRemovedEvent;
import com.esi.coreapi.event.VirementAddedEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    private Long idEtudiant;
    private String nom ;


    @JsonIgnore
    @AggregateMember
    @OneToMany(mappedBy = "etudiant")
    List<cartebib> cartebibs;

    //@Transient
    //EtudiantScolarite etudiantScolarite;

    @CommandHandler
    public void handle(AddCartebibCommand cmd) {
        //consitency rules
        this.cartebibs.add(new cartebib(cmd.getIdCartebib(),
                cmd.getSpecialite(),
                cmd.getAddress(),
                this
        ));


        AggregateLifecycle.apply(new CartebibAddEvent(
                this.nom,
                cmd.getIdCartebib(),
                cmd.getSpecialite()
        ));

    }

    @CommandHandler
    public void handle(RemouveCartebibCommand cmd, cartebibRepository cartebibRepository)

    {
        //constraint
        cartebib cartebib=new cartebib();
        cartebib.setIdCartebib(cmd.getIdCartebib());
        this.cartebibs.remove(cartebib);

        cartebibRepository.deleteById(cmd.getIdEtudiant());

        AggregateLifecycle.apply(new EtudiantRemovedEvent(cmd.getIdEtudiant()));

    }


}
