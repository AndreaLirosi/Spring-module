package develhope.APIMiddleware2.controllers;

import develhope.APIMiddleware2.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("/get")
    public Month getMonth(@RequestHeader(name = "monthNumber", required = false) int monthNumber, HttpServletRequest request) {

         return (Month)request.getAttribute("Month");
    }
}
