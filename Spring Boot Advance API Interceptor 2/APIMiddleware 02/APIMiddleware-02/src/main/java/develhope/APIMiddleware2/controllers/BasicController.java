package develhope.APIMiddleware2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BasicController {

    @RequestMapping("/get")
    public String welcome() {
        return "Welcome!";
    }
}
