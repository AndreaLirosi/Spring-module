package develhope.swagger.controllers;

import develhope.swagger.services.NameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    @Autowired
    NameServices nameServices;
    @GetMapping ("/")
    public String sayName(@RequestParam(value = "name") String name) {
        return nameServices.sayName(name);
    }
    @GetMapping("/invert")  //altro get con prefisso; entrambi sotto lo stesso controller.
    public String invertName(@RequestParam(value = "name") String name) {
        return nameServices.invertName(name);
    }
}
