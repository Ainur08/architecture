package ru.itis.architecture.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.architecture.mapper.FileMapper;
import ru.itis.architecture.models.File;
import ru.itis.architecture.models.FileEntity;
import ru.itis.architecture.models.FileFactory;
import ru.itis.architecture.models.TxtFile;
import ru.itis.architecture.models.enums.FileType;
import ru.itis.architecture.repositories.FilesRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FilesRepository filesRepository;
    private final FileMapper fileMapper;

    @Override
    public void save(MultipartFile multipartFile) {
        try {
            // путь
            Path path = Paths.get("files/" + multipartFile.getOriginalFilename());
            // располагает файл в файловой системе, где временно загруженный файл будет записан
            multipartFile.transferTo(path);

            // проверка на дубликат и сохранение имени файла в бд
            if (!filesRepository.findByName(multipartFile.getOriginalFilename()).isPresent()) {
                FileFactory fileFactory = new FileFactory();
                String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toUpperCase();
                File file = fileFactory.getFile(FileType.ANOTHER);
                try {
                    file = fileFactory.getFile(FileType.valueOf(extension));
                }catch (IllegalArgumentException e){
                    System.out.println(e);
                }
                file.setName(multipartFile.getOriginalFilename());
                filesRepository.save(fileMapper.toFileEntity(file));


            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<FileEntity> findAllFile() {
        return filesRepository.findAll();
    }
}
