package com.example.commandbib.entities;

import com.esi.coreapi.command.UpdateCartebibCommand;
import com.esi.coreapi.command.UpdateVirementCommand;
import com.esi.coreapi.event.CartebibAddEvent;
import com.esi.coreapi.event.CartebibUpdateEvent;
import com.esi.coreapi.event.VirementUpdateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class cartebib {
    @Id
    private Long idCartebib;
    private String Specialite ;
    private String Address;

    @ManyToOne
    private Etudiant etudiant;

    @CommandHandler
    public void on(UpdateCartebibCommand cmd)
    {
        // consitency rules

        this.Address=(cmd.getAddress()!=null) ? cmd.getAddress() : this.getAddress();
        this.Specialite=(cmd.getSpecialite()!=null) ? cmd.getSpecialite() : this.getSpecialite();

        AggregateLifecycle.apply(new CartebibUpdateEvent(
                cmd.getIdCartebib(),
                cmd.getAddress(),getSpecialite()
        ));
    }
}
