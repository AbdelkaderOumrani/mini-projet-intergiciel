package com.example.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixController {

    @GetMapping("defaultFormations")

     public String messageformation()

    {
        return "le service formation n'est plus disponible";
    }



    @GetMapping("defaultScolarite")
        public String messagescolarite()
    {

        return "le service scolarite n'est plus disponible";
    }

    @GetMapping("defaultBourse")
    public String messageversement()
    {

        return "le service bourse n'est plus disponible";
    }

    @GetMapping("defaultBib")
    public String messagebib()
    {

        return "le service cartebib n'est plus disponible";
    }

    @GetMapping("defaultQuery")
    public String messagequery()
    {

        return "le service query n'est plus disponible";
    }


}
