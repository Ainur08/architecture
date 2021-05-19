package ru.itis.architecture.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.architecture.configs.SenderConfig;
import ru.itis.architecture.models.State;
import ru.itis.architecture.models.User;
import ru.itis.architecture.repositories.UsersRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationServiceImpl implements ConfirmationService{
    private final UsersRepository usersRepository;
    // Singleton
    private final SenderConfig sender = SenderConfig.getInstance();

    @Async
    @Transactional
    @Override
    public void send(User user) {
        String mailText = "<a href='http://localhost/activate/" + user.getToken() + "'>Confirm</a>";
        sender.send("Подтверждение аккаунта", mailText, user.getEmail());
    }

    @Override
    public void checkConfirmation(String token) {
        Optional<User> optionalUser = usersRepository.findByToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
        }
    }
}
