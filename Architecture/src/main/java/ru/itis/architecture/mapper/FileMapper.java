package ru.itis.architecture.mapper;

import org.springframework.stereotype.Component;
import ru.itis.architecture.models.IFile;
import ru.itis.architecture.models.File;

@Component
public class FileMapper {

    public File toFileEntity(IFile IFile){
        return File.builder()
                        .name(IFile.getName())
                        .build();
    }
}
