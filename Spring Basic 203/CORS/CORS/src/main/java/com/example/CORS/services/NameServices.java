package com.example.CORS.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service // gestisce la logica di business

public class NameServices {


    public String sayName (String name) {
        return name;
    }
    public String invertName (String name) {
        StringBuilder reversedName =new StringBuilder(name).reverse();
        return reversedName.toString();
    }
}
