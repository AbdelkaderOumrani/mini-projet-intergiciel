package com.example.mscommandbourse.api;


import com.esi.coreapi.command.*;
import com.esi.coreapi.dto.VirementDTO;
import com.esi.coreapi.dto.etudiantDTO;
import com.example.mscommandbourse.entities.Virement;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("command")
public class ApiController {

    @Autowired
    CommandGateway commandGateway;


    @PostMapping("/etudiant/{ide}/virement")
    public String addVirement(@PathVariable Long  ide, @RequestBody VirementDTO VirementDTO)
    {
        commandGateway.send(new AddVirementCommand(
                ide,
                VirementDTO.getIdVirement(),
                VirementDTO.getMontant(),
                VirementDTO.getDateVirement()
        ));

        return "Added";
    }

    @PutMapping("/etudiant/{ide}/virement/{idv}")
    public String UpdateEtudiant(@PathVariable Long idf, @PathVariable Long idv, @RequestBody VirementDTO virementDTO)
    {
        commandGateway.send(new UpdateVirementCommand(
                idf,
                idv,
                virementDTO.getMontant(),
                virementDTO.getDateVirement()));

        return "updated";
    }


    @DeleteMapping("/etudiant/{ide}/virement/{idv}")
    public String DeleteEtudiant(@PathVariable Long id, @PathVariable Long idv)
    {
        commandGateway.send(new RemoveVirementCommand(id,idv));
        return "removed";
    }









}
