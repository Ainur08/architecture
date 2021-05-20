package ru.itis.architecture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.architecture.models.User;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByToken(String token);
}
