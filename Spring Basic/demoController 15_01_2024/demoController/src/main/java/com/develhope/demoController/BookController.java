package com.develhope.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    DbFinto db;

    @RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable int id) {
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                return "il libro è " + x;
            }
        }
        return "Il libro non esiste";
    }

    @PutMapping(path = "/book/{id}")
    public Libro updateBook(@PathVariable int id, @RequestBody BookRequest bookRequest) {
        Libro updated = null;
        for (Libro x : db.getBooks()) {
            if (x.getId() == id) {
                x.setAutore(bookRequest.getAutore());
                x.setTitolo(bookRequest.getTitolo());
                x.setEditore(bookRequest.getEditore());
                x.setPubblcazione(bookRequest.getPubblcazione());
                updated = x;
            }
        }
        return updated;
    }
}
