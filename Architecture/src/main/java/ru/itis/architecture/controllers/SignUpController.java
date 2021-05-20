package ru.itis.architecture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.architecture.dto.SignUpDto;
import ru.itis.architecture.services.interfaces.SignUpService;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpDto signUpDto) {
        signUpService.signUp(signUpDto);
        return "redirect:/signIn";
    }
}
