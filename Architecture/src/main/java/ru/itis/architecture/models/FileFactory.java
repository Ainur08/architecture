package ru.itis.architecture.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.architecture.models.enums.FileType;

@Builder
@Data
@AllArgsConstructor
public class FileFactory {
    public IFile getFile(FileType fileType){
        switch (fileType){
            case PNG:
                return new PngIFile();
            case TXT:
                return new TxtIFile();
            case ANOTHER:
                return new AnotherIFile();
            default: throw new IllegalArgumentException("Wrong file type");
        }
    }
}
