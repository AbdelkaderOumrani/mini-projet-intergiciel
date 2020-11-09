package com.example.mscommandbourse.entities;

import com.esi.coreapi.command.UpdateEtudiantCommand;
import com.esi.coreapi.command.UpdateVirementCommand;
import com.esi.coreapi.event.EtudiantUpdatedEvent;
import com.esi.coreapi.event.VirementUpdateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Virement {
    @Id
    private Long idVirement;

    private Float montant;
    private Date dateVirement;

    @ManyToOne
    private Etudiant etudiant;

    @CommandHandler
    public void on(UpdateVirementCommand cmd)
    {
        // consitency rules

        this.dateVirement=(cmd.getDateVirement()!=null) ? cmd.getDateVirement() : this.getDateVirement();
        this.montant=(cmd.getMontant()!=null) ? cmd.getMontant() : this.getMontant();

        AggregateLifecycle.apply(new VirementUpdateEvent(
                cmd.getIdVirement(),
                cmd.getMontant(),getDateVirement()
        ));
    }
}
