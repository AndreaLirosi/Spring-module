package com.example.controllerGETPost.controllers;

import com.example.controllerGETPost.service.NameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NameController {

    @Autowired //è un'annotazione di Spring Framework che viene utilizzata per l'iniezione di dipendenze automatica. Quando si dichiara un campo con @Autowired, Spring si occuperà di fornire l'istanza appropriata della classe richiesta durante l'esecuzione del programma.
    NameServices nameServices; // nome della dipendenza

    @GetMapping ("/")   //get senza prefisso
    public String sayName(@RequestParam(value = "name") String name) {
        return nameServices.sayName(name);
    }
    @PostMapping("/invert")  //altro get con prefisso; entrambi sotto lo stesso controller.
    public String invertName(@RequestBody String name) {
        return nameServices.invertName(name);
    }
}
