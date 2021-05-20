package ru.itis.architecture.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.architecture.models.File;

import java.util.List;

public interface FileService {
    void save(MultipartFile multipartFile);

    List<File> findAllFile();
}
