package ru.itis.architecture.services.impl;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.architecture.dto.FileDto;
import ru.itis.architecture.services.interfaces.DownloadService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Async
    @Transactional
    @Override
    public FileDto getTemplateFile(String fileName){
        try {
            String filePath = "files/" + fileName;
            File file = new File(filePath);
            // байтовая реализация интерфеса Resource, получение ресурса файла
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            // перевод ресурса файла в массив байтов
            byte[] templateBytes = IOUtils.toByteArray(resource.getInputStream());
            // создание и возврат dto файла
            return FileDto.builder()
                    .name(fileName)
                    .resource(new ByteArrayResource(templateBytes))
                    .build();
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }
}
