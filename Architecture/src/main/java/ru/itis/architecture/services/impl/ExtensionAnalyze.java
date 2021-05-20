package ru.itis.architecture.services.impl;

import lombok.Builder;
import ru.itis.architecture.services.interfaces.Analyze;

@Builder
public class ExtensionAnalyze implements Analyze {
    @Override
    public String analyze(String name) {
        return name.substring(name.lastIndexOf("."));
    }
}
