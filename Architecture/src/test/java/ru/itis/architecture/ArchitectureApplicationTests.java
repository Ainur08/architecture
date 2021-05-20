package ru.itis.architecture;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import ru.itis.architecture.dto.FileDto;
import ru.itis.architecture.models.FileEntity;
import ru.itis.architecture.repositories.FilesRepository;
import ru.itis.architecture.services.impl.DownloadServiceImpl;
import ru.itis.architecture.services.impl.FileServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class ArchitectureApplicationTests {
    @InjectMocks
    private FileServiceImpl fileService;

    @Mock
    private FilesRepository filesRepository;

    @Autowired
    DownloadServiceImpl downloadService;

    //Тестируем что метод save() работает корректно
    @Test
    public void saveFileTest(){
        FileEntity file = FileEntity.builder()
                        .name("test.txt")
                        .build();

        MockMultipartFile mockMultipartFile
                = new MockMultipartFile(
                "test",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );

        //возвращаем пустой Optional, имитируем что файла нет в бд
        when(filesRepository.findByName(Mockito.any())).thenReturn(Optional.empty());

        //возвращаем объект file, как и при сохранении в бд
        when(filesRepository.save(file)).thenReturn(file);

        //вызываем тестируемый метод
        fileService.save(mockMultipartFile);

        //проверяем что метод save() у FileRepository вызвался, считаем что на данном шаге файл сохранен
        verify(filesRepository, times(1)).save(file);
    }

    //Проверяем что метод findAllFiles() работает корректно
    @Test
    public void findAllFilesTest(){
        List<FileEntity> actualFiles = new ArrayList<>();
        actualFiles.add(FileEntity.builder()
                .name("test1.txt")
                .build());
        actualFiles.add(FileEntity.builder()
                .name("test2.txt")
                .build());
        actualFiles.add(FileEntity.builder()
                .name("test3.txt")
                .build());

        List<FileEntity> expectedFiles = new ArrayList<>();
        expectedFiles.add(FileEntity.builder()
                .name("test1.txt")
                .build());
        expectedFiles.add(FileEntity.builder()
                .name("test2.txt")
                .build());
        expectedFiles.add(FileEntity.builder()
                .name("test3.txt")
                .build());

        //Возвращаем List<File> со всеми файлами, имитируем поведение бд
        when(fileService.findAllFile()).thenReturn(actualFiles);

        //Проверяем что метод findAll вернул все файлы
        assertThat(expectedFiles.containsAll(fileService.findAllFile())).isTrue();
    }

    //Проверяем на корректность работу метода getTemplateFile
    @Test
    public void getTemplateFileTest(){
        //Создаем мок файл для того чтобы получить resource
        MockMultipartFile mockMultipartFile
                = new MockMultipartFile(
                "test",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );
        FileDto expectedFileDto = FileDto.builder()
                .name("test.txt")
                .resource(mockMultipartFile.getResource())
                .build();

        //Вызываем проверяемый метод и сохраняем значение в actualFileDto
        FileDto actualFileDto = downloadService.getTemplateFile("test.txt");

        //Проверяем что вернулся правильный FileDto
        assertThat(actualFileDto.getName()).isEqualTo(expectedFileDto.getName());
    }

}
