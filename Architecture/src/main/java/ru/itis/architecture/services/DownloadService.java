package ru.itis.architecture.services;

import ru.itis.architecture.dto.FileDto;

public interface DownloadService {
    FileDto getTemplateFile(String fileName);
}
