package com.esi.coreapi.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddCartebibCommand {
    @TargetAggregateIdentifier
    private Long idEtudiant ;
    private Long idCartebib;
    private String Specialite ;
    private String Address;
}
