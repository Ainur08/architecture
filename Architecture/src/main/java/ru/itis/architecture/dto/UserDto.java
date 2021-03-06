package ru.itis.architecture.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.architecture.models.User;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
