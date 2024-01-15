package com.example.demowebapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/v1") // prefisso dei metodi
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, // tipo di chiamata che si vuole fare
                    path = "/helloWorld")       // metodo che si vuole richiamare
    public String helloworld () {               // metodo richiamato
        return "Hello World!";
    }
}
