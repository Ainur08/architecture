package ru.itis.architecture.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.architecture.dto.FileDto;
import ru.itis.architecture.services.DownloadService;

@RestController
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @GetMapping("/api/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
        try {
            // получение dto файла и его ресурса
            FileDto fileDto = downloadService.getTemplateFile(fileName);

            // создаём заголовки для ответа
            HttpHeaders headers = new HttpHeaders();
            headers.add("FileName", fileName);
            // указывает браузеру открыть окно загрузки файла, вместо того, чтобы пытаться проанализировать содержимое
            headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", fileName));

            // формирование ответа с headers, body (resource of file), contentLength,
            // contentType (неопределённые бинарные данные, вызов диалогового окна «Сохранить Как»)
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fileDto.getResource().contentLength())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(fileDto.getResource());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
