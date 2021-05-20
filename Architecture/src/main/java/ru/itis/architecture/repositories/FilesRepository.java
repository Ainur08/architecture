package ru.itis.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.architecture.models.FileEntity;
import java.util.Optional;

public interface FilesRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByName(String name);

    void deleteByName(String name);
}
