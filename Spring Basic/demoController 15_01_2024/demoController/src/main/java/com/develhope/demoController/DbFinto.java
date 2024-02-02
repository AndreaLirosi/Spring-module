package com.develhope.demoController;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Component("dbFinto")
public class DbFinto {

    public ArrayList<Libro> getBooks() {
        ArrayList<Libro> libroDB = new ArrayList<>();
        Libro libro = new Libro("Harry Potter", "Rowling", "Antonio Iovine", 2000, 123);
        Libro libro1 = new Libro("Harry Potter 2", "Rowling 2.0", "Antonio Iovine Super Sayan", 2002, 134);
        Libro libro2 = new Libro("L'Imperatore", "Antonio Buonanno", "Luca Savini production", 2023, 998);
        Libro libro3 = new Libro("L'Imperatore il ritorno", "Antonio Buonanno Musician", "Luca Savini production", 2023, 999);

        libroDB.add(libro);
        libroDB.add(libro1);
        libroDB.add(libro2);
        libroDB.add(libro3);

        return libroDB;
    }


}
