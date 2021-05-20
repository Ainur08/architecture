package ru.itis.architecture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.architecture.services.interfaces.FileService;

@Controller
public class MainController implements WebMvcConfigurer {
    @Autowired
    private FileService fileService;

    @GetMapping("/main")
    public String listOfFiles(Model model) {
        model.addAttribute("files", fileService.findAllFile());
        return "main";
    }

    @PostMapping("/main")
    public String saveFile(@RequestParam("file") MultipartFile multipartFile) {
        fileService.save(multipartFile);
        return "redirect:/main";
    }
}
