package ru.itis.architecture.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.architecture.dto.SignUpDto;
import ru.itis.architecture.generators.ConfirmationTokenGenerator;
import ru.itis.architecture.models.State;
import ru.itis.architecture.models.User;
import ru.itis.architecture.repositories.UsersRepository;
import ru.itis.architecture.services.interfaces.ConfirmationService;
import ru.itis.architecture.services.interfaces.SignUpService;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationService confirmationService;
    // Singleton
    private final ConfirmationTokenGenerator generator = ConfirmationTokenGenerator.getInstance();

    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        User user = usersRepository.save(User.builder()
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .state(State.NOT_CONFIRMED)
                .token(generator.generate())
                .build());
        confirmationService.send(user);
    }
}
