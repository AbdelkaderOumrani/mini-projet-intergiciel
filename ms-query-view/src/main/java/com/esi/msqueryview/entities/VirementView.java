package com.esi.msqueryview.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirementView {

    @Id
    private String nom;
    private Float montant;
    private Date dateVirement;
}
