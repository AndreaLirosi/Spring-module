package com.example.controllerGETPost.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service // indica un servizio che viene usato (permettendo di separare la logica dal resto
public class NameServices {

    @GetMapping (path = "/") // sistema per fare il GET (una tipologia di chiamata). Nel metodo "sayName" il fatto di mettere nei parametri (value = "") indica che il seguente valore verrà impostato nella richiesta https.
    public String sayName (@RequestParam (value = "name") String name) {
        return name;
    }
    public String invertName(@RequestParam (value = "name") String name) {

        StringBuilder reversedName = new StringBuilder(name).reverse(); // StringBuilder è una classe in Java che fornisce un modo efficiente per manipolare e costruire stringhe dinamicamente. A differenza della classe String, che è immutabile (ogni modifica crea una nuova stringa), StringBuilder è mutabile, il che significa che puoi modificare il contenuto della stringa senza creare nuove istanze di oggetto.
        return reversedName.toString();
    }
}
