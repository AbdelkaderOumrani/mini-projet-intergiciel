package com.esi.msqueryview.entities;


import com.esi.coreapi.event.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class CartebibProjection {

    @Autowired
    CarteViewRepository carteViewRepository;


    @EventHandler
    public void on(CartebibAddEvent event)
    {
        carteViewRepository.save(new CartebibView(event.getNom(),event.getIdCartebib(),event.getAddress()));

    }

    @EventHandler
    public void on(CartebibUpdateEvent event)
    {
        CartebibView cartebibView=carteViewRepository.findById(event.getIdCartebib()).get();

        if(event.getAddress()!=null) cartebibView.setAddress(event.getAddress());

        carteViewRepository.save(cartebibView);

    }

    @EventHandler
    public void handle(CartebibRemovedEvent event)
    {
        carteViewRepository.deleteById(event.getIdCartebib());

    }

}
