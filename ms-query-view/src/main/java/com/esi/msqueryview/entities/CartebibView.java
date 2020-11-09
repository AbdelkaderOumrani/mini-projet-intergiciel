package com.esi.msqueryview.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartebibView {

    @Id
    private String  nom;
    private Long idCartebib;
    private String Address;

}
