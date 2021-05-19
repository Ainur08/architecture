package ru.itis.architecture.services;

import ru.itis.architecture.models.User;

public interface ConfirmationService {
    void send(User user);
    void checkConfirmation(String token);
}
