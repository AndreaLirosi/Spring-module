package com.example.Environment.Variables1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saluti")
public class BasicController {

    @Value("${myCustomVarTree.devName}")
    private String devName;

    @Value("${myCustomVarTree.authCode}")
    private String authCode;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, developer " + devName + "! Your auth code is: " + authCode;
    }
}
