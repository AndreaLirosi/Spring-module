package develhope.swagger.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class NameServices {

    @GetMapping("/")
    public String sayName (@RequestParam (value = "name") String name) {
        return name;
    }
public String invertName (@RequestParam (value = "name") String name) {
StringBuilder reversedName =new StringBuilder(name).reverse();
    return reversedName.toString();
    }
}
