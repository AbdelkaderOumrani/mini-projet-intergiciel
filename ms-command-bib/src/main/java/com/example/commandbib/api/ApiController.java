package com.example.commandbib.api;


import com.esi.coreapi.command.AddCartebibCommand;
import com.esi.coreapi.command.UpdateCartebibCommand;
import com.esi.coreapi.command.RemouveCartebibCommand;

import com.esi.coreapi.dto.CartebibDTO;
import com.esi.coreapi.dto.VirementDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("command")
public class ApiController {

    @Autowired
    CommandGateway commandGateway;


    @PostMapping("/etudiant/{ide}/cartebib")
    public String addVirement(@PathVariable Long  ide, @RequestBody CartebibDTO cartebibDTO)
    {
        commandGateway.send(new AddCartebibCommand(
                ide,
                cartebibDTO.getIdCartebib(),
                cartebibDTO.getSpecialite(),
                cartebibDTO.getSpecialite()
        ));

        return "Added";
    }

    @PutMapping("/etudiant/{ide}/cartebib/{idv}")
    public String UpdateEtudiant(@PathVariable Long ide, @PathVariable Long idb, @RequestBody CartebibDTO cartebibDTO)
    {
        commandGateway.send(new UpdateCartebibCommand(
                ide,
                idb,
                cartebibDTO.getSpecialite(),
                cartebibDTO.getAddress()));

        return "updated";
    }


    @DeleteMapping("/etudiant/{ide}/cartebib/{idv}")
    public String DeleteEtudiant(@PathVariable Long id, @PathVariable Long idv)
    {
        commandGateway.send(new RemouveCartebibCommand(id,idv));
        return "removed";
    }









}
