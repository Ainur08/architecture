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
            FileDto fileDto = downloadService.getTemplateFile(fileName);

            HttpHeaders headers = new HttpHeaders();
            headers.add("FileName", fileName);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", fileName));

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
