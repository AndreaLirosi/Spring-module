package com.example.Deploy02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/Random")
public class SumController {

    @GetMapping("/sum")
    public String sumCustomNumber() {
        Random random = new Random();
        int n1 = random.nextInt(100);
        int n2 = random.nextInt(100);
        int sum = n1+n2;
        return "la somma dei numeri " + n1 + " e " + n2 + " è uguale a " + sum;
    }
}
