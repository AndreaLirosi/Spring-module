package develhope.API.Interceptor.Middleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/time")
public class BasicController {

    @GetMapping("/now")
    public String getTime () {
        return LocalDateTime.now().toString();
    }
}
