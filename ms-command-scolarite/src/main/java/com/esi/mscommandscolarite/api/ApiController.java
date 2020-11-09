package com.esi.mscommandscolarite.api;


import com.esi.coreapi.command.UpdateEtudiantCommandEta;

import com.esi.coreapi.command.CreateEtablissmentCommand;
import com.esi.coreapi.command.RemoveEtudiantCommandEta;
import com.esi.coreapi.command.AddEtudiantCommandEta;

import com.esi.coreapi.dto.EtablissementDTO;
import com.esi.coreapi.dto.etudiantDTOeta;
import com.esi.coreapi.dto.formationDTO;
import com.esi.mscommandscolarite.entities.Etudiant;
import com.esi.mscommandscolarite.model.Formation;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("command")
public class ApiController {

    @Autowired
    CommandGateway commandGateway;




@PostMapping("/etablissement")
public String newFormation(@RequestBody EtablissementDTO etablissementDTO)
{
    commandGateway.send(new CreateEtablissmentCommand(
            etablissementDTO.getIdEtablissement(),
            etablissementDTO.getNom()));

    return "created";
}


@PostMapping("/etablissement/{idf}/etudiant")
    public String addEtudiant(@PathVariable String  idf, @RequestBody etudiantDTOeta etudiantDTOeta)
{
    commandGateway.send(new AddEtudiantCommandEta(
            idf,
            etudiantDTOeta.getIdEtudiant(),
            etudiantDTOeta.getNom(),
            etudiantDTOeta.getDateN(),
            etudiantDTOeta.getPromo(),
            etudiantDTOeta.getDateInscription()
    ));



    return "Added";
}


    @PutMapping("/etablissement/{id}/etudiant/{ide}")
    public String UpdateEtudiant(@PathVariable String id, @PathVariable Long ide, @RequestBody etudiantDTOeta etudiantDTOeta)
    {
        commandGateway.send(new UpdateEtudiantCommandEta(
                id,
                ide,
                etudiantDTOeta.getNom(),
                etudiantDTOeta.getDateN(),
                etudiantDTOeta.getPromo(),
                etudiantDTOeta.getDateInscription()));

        return "updated";
    }

    @DeleteMapping("/etablissement/{id}/etudiant/{ide}")
    public String DeleteEtudiant(@PathVariable String id, @PathVariable Long ide)
    {
        commandGateway.send(new RemoveEtudiantCommandEta(id,ide));
        return "removed";
    }
}
