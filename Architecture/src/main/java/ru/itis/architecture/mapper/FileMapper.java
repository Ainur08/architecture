package ru.itis.architecture.mapper;

import lombok.experimental.UtilityClass;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.itis.architecture.models.File;
import ru.itis.architecture.models.FileEntity;

@Component
public class FileMapper {

    public FileEntity toFileEntity(File file){
        return FileEntity.builder()
                        .name(file.getName())
                        .build();
    }
}
