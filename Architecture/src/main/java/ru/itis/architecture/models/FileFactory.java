package ru.itis.architecture.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.architecture.models.enums.FileType;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
public class FileFactory {
    public File getFile(FileType fileType){
        switch (fileType){
            case PNG:
                return new PngFile();
            case TXT:
                return new TxtFile();
            case ANOTHER:
                return new AnotherFile();
            default: throw new IllegalArgumentException("Wrong file type");
        }
    }
}
