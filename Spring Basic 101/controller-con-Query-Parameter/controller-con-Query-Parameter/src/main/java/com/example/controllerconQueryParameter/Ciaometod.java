package com.example.controllerconQueryParameter;


import org.springframework.web.bind.annotation.*;

@RestController // componente che si usa per, tramite uso di chiamate REST, comunicare col                      server
@RequestMapping ("/v1") // questo sarà il prefisso per le chiamate.

public class Ciaometod {    // metodo
@GetMapping (path = "/ciao")
public String greet (@RequestParam String name, @RequestParam String place) {
    return "Ciao " + name + "!\n " + "Com'è il tempo in " + place + "?";
}

}
