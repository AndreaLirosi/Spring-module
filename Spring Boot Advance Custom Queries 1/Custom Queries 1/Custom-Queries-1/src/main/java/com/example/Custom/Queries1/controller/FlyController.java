package com.example.Custom.Queries1.controller;

import com.example.Custom.Queries1.entity.Flight;
import com.example.Custom.Queries1.entity.TypeFlight;
import com.example.Custom.Queries1.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/Fly")
public class FlyController {

    @Autowired
    private FlightRepo flightRepo;

    @GetMapping("/get")
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @PostMapping("/provision")
    //andiamo a creare una lista di voli
    public List<Flight> provisionFlights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        //andiamo a generare oggetti di tipo flight, i nostri voli, in modo casuale
        for (int i = 0; i < 10; i++) {
            Flight flight = new Flight();
            //usiamo un generatore casuale di stringe per la descrizione e altri parametri
            flight.setDescription(generateRandomString());
            flight.setFromAirport(generateRandomString());
            flight.setToAirport(generateRandomString());
            // li settiamo tutti su ONTIME e li aggiungiamo
            flight.setTypeFlight(TypeFlight.ONTIME);
            flights.add(flight);
        }
        // questo ci permette di salvarli
        return flightRepo.saveAll(flights);
    }

    // per generare parole casuali si usa random.ints.
    private String generateRandomString() {
        // qui si pongono i limiti che vanno da 97 a 122 (valori ASCII delle lettere minuscole) e si pone la lunghezza della parola
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();// chiamiamo la funzione Random
    // random int genera una sequenza di numeri interi casuali
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)// impostiamo il limite
                // collect raccoglie gli elementi del flusso in una struttura specifica (stringBuilder) il quale fornisce un nuovo oggetto e raccoglie i numeri e append va ad'unire il risultato precedente con quello successivo
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                //infine viene trasformato in stringa
                .toString();
    }
}
