package com.esi.msqueryview.entities;


import com.esi.coreapi.event.EtudiantAddedEventEtab;
import com.esi.coreapi.event.EtudiantRemovedEventEtab;
import com.esi.coreapi.event.EtudiantUpdatedEventEtab;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EtudiantProjectionE {


    @Autowired
    EtudiantViewRepositoryE etudiantViewRepositoryE;

    @EventHandler
    public void on(EtudiantAddedEventEtab event)
    {
        etudiantViewRepositoryE.save(new EtudiantViewE(event.getIdEtudiant(),event.getNomEtablissement(),event.getNom()));


    }



    @EventHandler
    public void on(EtudiantUpdatedEventEtab event)
    {
        EtudiantViewE etudiantViewE=etudiantViewRepositoryE.findById(event.getIdEtudiant()).get();

        if(event.getNom()!=null) etudiantViewE.setNom(event.getNom());




        etudiantViewRepositoryE.save(etudiantViewE);

    }

    @EventHandler
    public void handle(EtudiantRemovedEventEtab event)
    {
        etudiantViewRepositoryE.deleteById(event.getIdEtudiant());

    }



}
