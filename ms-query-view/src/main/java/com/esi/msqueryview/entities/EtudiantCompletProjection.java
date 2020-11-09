package com.esi.msqueryview.entities;


import com.esi.coreapi.event.EtudiantAddedEvent;
import com.esi.coreapi.event.EtudiantAddedEventComplet;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class EtudiantCompletProjection {


    @Autowired
    EtudiantCompletViewRepository etudiantCompletViewRepository ;


    @EventHandler
    public void on(EtudiantAddedEventComplet event)
    {

        etudiantCompletViewRepository.save(new EtudiantCompletView(event.getIdEtudiant(),event.getNom(),event.getNomFormation(),event.getNomEtablissement()));
        //  etudiantViewRepository.save(new EtudiantView(event.getIdEtudiant(),event.getNom(),event.getNomFormation(),event.getNomEtablissement()));

    }
}
