package ru.itis.architecture.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.architecture.services.ConfirmationService;

@RestController
public class EmailConfirmController {
    @Autowired
    private ConfirmationService confirmationService;

    @GetMapping("/activate/{token}")
    public ResponseEntity<?> activate(@PathVariable("token") String token){
        confirmationService.checkConfirmation(token);
        return ResponseEntity.ok().build();
    }
}
