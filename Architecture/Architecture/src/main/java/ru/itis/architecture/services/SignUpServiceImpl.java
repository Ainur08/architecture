package ru.itis.architecture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.architecture.dto.SignUpDto;
import ru.itis.architecture.models.User;
import ru.itis.architecture.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        User user = usersRepository.save(User.builder()
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
//                .state(State.NOT_CONFIRMED)
//                .token(ConfirmationTokenGenerator.generate())
                .build());

//        HashMap<String, Object> parameters = new HashMap<>();
//        parameters.put("token", user.getToken());
//        confirmationService.send(EmailDto.builder()
//                .to(user.getEmail())
//                .subject("Confirm email")
//                .map(parameters)
//                .template("confirmationEmail.ftlh")
//                .build());
    }
}
