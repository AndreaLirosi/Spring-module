package develhope.swagger.controllers;

import develhope.swagger.services.NameServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@ApiResponse(description = "name manipulation") // descrive l'operazione che farà l'API.
public class NameController {

    @Autowired
    NameServices nameServices;
    @Operation(summary = "GetName", description = "ritorna un nome") //descrive l'operazione che compie la specifica API, e la risposta che si avrà (response), nel caso una stringa.
    @ApiResponses(value = { // queste descrivono le possibili risposte che l'operazione può restituire
            @ApiResponse(responseCode = "200", description = "Successfully retrieved name"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Name not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping ("/getName") // tipo di Endpoint che fa tornare indietro un nome
    public String getName(@RequestParam(value = "name") String name) {
        return nameServices.sayName(name);
    }


    @Operation(summary = "nome invertito",description = "ritorna il nome invertito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully reversed name"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Name not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping("/reverseName")  //altro get con prefisso; entrambi sotto lo stesso controller.
    public String invertName(@RequestParam(value = "name") String name) {
        return nameServices.invertName(name);
    }
}
