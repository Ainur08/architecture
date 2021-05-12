package ru.itis.architecture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MainController implements WebMvcConfigurer {

    @GetMapping("/main")
    public String listOfSchedule(Model model) {
        return "main";
    }
}
