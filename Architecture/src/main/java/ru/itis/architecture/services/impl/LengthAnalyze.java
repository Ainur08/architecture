package ru.itis.architecture.services.impl;

import lombok.Builder;
import ru.itis.architecture.services.interfaces.Analyze;
import java.io.File;

@Builder
public class LengthAnalyze implements Analyze {
    @Override
    public String analyze(String name) {
        String filePath = "files/" + name;
        File file = new File(filePath);
        return String.valueOf(file.length());
    }
}
