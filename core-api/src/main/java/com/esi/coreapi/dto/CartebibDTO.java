package com.esi.coreapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartebibDTO {

    private Long idCartebib;
    private String Specialite ;
    private String Address;
}
