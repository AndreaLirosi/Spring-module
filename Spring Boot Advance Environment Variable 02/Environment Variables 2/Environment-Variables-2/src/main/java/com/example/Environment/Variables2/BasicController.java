package com.example.Environment.Variables2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saluti")
public class BasicController {

    @Autowired
    private EnvironmentVariables2Application environmentVariables2Application;

    @Value("${myCustomVarTree.welcomeMsg}")
    private String welcomeMsg;

    @GetMapping("/greeting")
    public String greeting() {
        return welcomeMsg;
    }
}
