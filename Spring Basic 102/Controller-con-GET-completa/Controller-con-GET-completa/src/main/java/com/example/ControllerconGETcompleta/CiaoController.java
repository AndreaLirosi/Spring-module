package com.example.ControllerconGETcompleta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class CiaoController {
    @GetMapping(path = "/ciao/{province}")

    public User greet (@RequestParam(value = "name")String name,
                       @RequestParam(value = "province", required = false, defaultValue = " ")String province)

    /* i parametri passati hanno sintassi (valore = ) Tipo e nome della variabile.
    *  i parametri possono essere facoltativi ",required = false" con valore di default,
    *  o possono essere obbligatori (se non specificato sono, di base, obbligatori
    *  la sintassi "%s" permette di rendere variabile il valore dato allo spazio */
    {
        String greeting = "Ciao %s, com'è il tempo in %s";
        String formattedGreeting = String.format(greeting, name, province);
        return new User(name, province, formattedGreeting);
    }
}
