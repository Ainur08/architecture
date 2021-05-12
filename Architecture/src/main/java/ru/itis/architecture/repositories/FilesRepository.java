package ru.itis.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.architecture.models.File;
import java.util.Optional;

public interface FilesRepository extends JpaRepository<File, Long> {
    Optional<File> findByName(String name);
}
