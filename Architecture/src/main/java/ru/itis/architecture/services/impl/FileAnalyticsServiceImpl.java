package ru.itis.architecture.services.impl;

import org.springframework.stereotype.Service;
import ru.itis.architecture.services.interfaces.Analyze;
import ru.itis.architecture.services.interfaces.FileAnalyticsService;

@Service
public class FileAnalyticsServiceImpl implements FileAnalyticsService {
    private Analyze strategy;

    @Override
    public String analyze(String name, String operation) {
        switch (operation){
            case "length":
                strategy = LengthAnalyze.builder().build();
                break;
            case "extension":
                strategy = ExtensionAnalyze.builder().build();
                break;
        }
        return strategy.analyze(name);
    }
}
