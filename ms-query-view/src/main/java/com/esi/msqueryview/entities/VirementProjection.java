package com.esi.msqueryview.entities;

import com.esi.coreapi.event.*;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class VirementProjection {

    @Autowired
    VirementViewRepository virementViewRepository;

    @EventHandler
    public void on(VirementAddedEvent event)
    {
        virementViewRepository.save(new VirementView(event.getNom(),event.getMontant(),event.getDateVirement()));
        //  etudiantViewRepository.save(new EtudiantView(event.getIdEtudiant(),event.getNom(),event.getNomFormation(),event.getNomEtablissement()));



    }

    @EventHandler
    public void on(VirementUpdateEvent event)
    {
        VirementView virementView=virementViewRepository.findById(event.getIdVirement()).get();

        if(event.getDateVirement()!=null) virementView.setDateVirement(event.getDateVirement());

        virementViewRepository.save(virementView);

    }

    @EventHandler
    public void handle(VirementRemovedEvent event)
    {
        virementViewRepository.deleteById(event.getIdVirement());

    }
}
