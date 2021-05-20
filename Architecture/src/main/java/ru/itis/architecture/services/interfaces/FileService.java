package ru.itis.architecture.services.interfaces;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.architecture.models.FileEntity;
import ru.itis.architecture.models.TxtFile;
import java.util.List;

public interface FileService {
    void save(MultipartFile multipartFile);

    List<FileEntity> findAllFile();
}
