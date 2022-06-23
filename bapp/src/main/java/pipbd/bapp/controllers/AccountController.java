package pipbd.bapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AccountController {

    public DataGeneratorService dataGeneratorService;

    @GetMapping("/generate")
    public String generateData(){
        dataGeneratorService.generateAmountOfClients(20);
        return "check terminal";
    }

}
