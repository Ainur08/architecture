package ru.itis.architecture.services;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.architecture.dto.FileDto;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DownloadServiceImpl implements DownloadService{
    @Async
    @Transactional
    @Override
    public FileDto getTemplateFile(String fileName){
        try {
            String filePath = "files/" + fileName;
            File file = new File(filePath);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            byte[] templateBytes = IOUtils.toByteArray(resource.getInputStream());
            return FileDto.builder()
                    .name(fileName)
                    .resource(new ByteArrayResource(templateBytes))
                    .build();
        } catch (IOException e){
            throw new IllegalArgumentException(e);
        }
    }
}
