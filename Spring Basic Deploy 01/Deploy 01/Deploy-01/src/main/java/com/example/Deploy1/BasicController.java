package com.example.Deploy1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BasicController {

    @Value("${info.app.devName}")
    private String devName;

    @GetMapping("/devName")
    public String getDevName(){
        return devName;
    }
}
