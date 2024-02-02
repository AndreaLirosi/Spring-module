package com.develhope.demoController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/books")
@Tag(name = "BookController", description = "Version 2")
public class BookControllerV2 {

    @Autowired
    DbFinto db;

    @RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
    @Operation(summary = "Restituisce un libro a partire da un id", description = "Restituisce un libro a partire da un id")
    public String getBook(@PathVariable int id) {
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                return "il libro è " + x;
            }
        }
        return "Il libro non esiste";
    }

    @PutMapping(path = "/book/{id}")
    @Operation(summary = "Aggiorna un libro a partire da un id", description = "Aggiorna un libro a partire da un id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Non è presente il libro con quell'id"),
            @ApiResponse(responseCode = "436", description = "Utente non abilitato"),
    }
    )
    @Parameter(name = "id", description = "Id del libro che si vuole aggiornare")
    public Libro updateBook(@PathVariable int id, @RequestBody BookRequest bookRequest) {
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                x.setAutore(bookRequest.getAutore());
                x.setTitolo(bookRequest.getTitolo());
                x.setEditore(bookRequest.getEditore());
                x.setPubblcazione(bookRequest.getPubblcazione());
                return x;
            }
        }
        return null;
    }
}
