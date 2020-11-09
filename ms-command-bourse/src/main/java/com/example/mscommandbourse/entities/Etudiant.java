package com.example.mscommandbourse.entities;

//import com.esi.msbourse.model.EtudiantScolarite;
import com.esi.coreapi.command.AddEtudiantCommand;
import com.esi.coreapi.command.AddVirementCommand;
import com.esi.coreapi.command.RemoveEtudiantCommand;
import com.esi.coreapi.command.RemoveVirementCommand;
import com.esi.coreapi.event.EtudiantAddedEvent;
import com.esi.coreapi.event.EtudiantRemovedEvent;
import com.esi.coreapi.event.VirementAddedEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Etudiant {
    @Id
    private Long idEtudiant;


    private String nCompteCCP;
    private Float salaireParant;
    private Boolean situationImpot;

    @JsonIgnore
    @AggregateMember
    @OneToMany(mappedBy = "etudiant")
    List<Virement> virements;

    //@Transient
    //EtudiantScolarite etudiantScolarite;

    @CommandHandler
    public void handle(AddVirementCommand cmd) {
        //consitency rules
        this.virements.add(new Virement(
                cmd.getIdVirement(),
                cmd.getMontant(),
                cmd.getDateVirement(), this
        ));


        AggregateLifecycle.apply(new VirementAddedEvent(this.nCompteCCP
                ,
                cmd.getMontant(),
                cmd.getDateVirement()
        ));

    }

    @CommandHandler
    public void handle(RemoveVirementCommand cmd, VirementRepository virementRepository)

    {
        //constraint
        Virement virement=new Virement();
        virement.setIdVirement(cmd.getIdVirement());
        this.virements.remove(virement);

        virementRepository.deleteById(cmd.getIdEtudiant());

        AggregateLifecycle.apply(new EtudiantRemovedEvent(cmd.getIdEtudiant()));

    }


}
