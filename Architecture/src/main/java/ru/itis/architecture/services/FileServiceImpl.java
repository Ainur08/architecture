package ru.itis.architecture.services;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FilesRepository filesRepository;

    @Override
    public void save(MultipartFile multipartFile) {
        try {
            Path path = Paths.get("files/" + multipartFile.getOriginalFilename());
            multipartFile.transferTo(path);

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
