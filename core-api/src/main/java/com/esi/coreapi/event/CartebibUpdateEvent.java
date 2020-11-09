package com.esi.coreapi.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartebibUpdateEvent {
    private Long idCartebib;
    private String Specialite ;
    private String Address;


}
