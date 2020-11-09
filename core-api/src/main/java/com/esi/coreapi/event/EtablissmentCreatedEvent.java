package com.esi.coreapi.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtablissmentCreatedEvent {



        @TargetAggregateIdentifier
        private String idEtablissment;
        private String nom;

}
