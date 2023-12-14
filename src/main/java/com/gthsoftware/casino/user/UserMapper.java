package com.gthsoftware.casino.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserMapper implements Function<UserDTO,User> {

    @Override
    public User apply(@NotNull UserDTO userDTO) {
        return new User(
                userDTO.id(),
                userDTO.firstName(),
                userDTO.lastName(),
                userDTO.email(),
                userDTO.dateOfBirth()
                );
    }
}
