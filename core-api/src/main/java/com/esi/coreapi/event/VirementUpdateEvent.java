package com.esi.coreapi.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirementUpdateEvent {

    private Long idVirement;

    private Float montant;
    private Date dateVirement;
}
