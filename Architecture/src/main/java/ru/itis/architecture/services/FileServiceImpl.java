package ru.itis.architecture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.architecture.models.File;
import ru.itis.architecture.repositories.FilesRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FilesRepository filesRepository;

    @Override
    public void save(MultipartFile multipartFile) {
        try {
            // путь
            Path path = Paths.get("files/" + multipartFile.getOriginalFilename());
            // располагает файл в файловой системе, где временно загруженный файл будет записан
            multipartFile.transferTo(path);

            // проверка на дубликат и сохранение имени файла в бд
            if (!filesRepository.findByName(multipartFile.getOriginalFilename()).isPresent()) {
                filesRepository.save(File.builder()
                        .name(multipartFile.getOriginalFilename())
                        .build());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<File> findAllFile() {
        return filesRepository.findAll();
    }
}
