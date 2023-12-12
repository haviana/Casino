package com.gthsoftware.casino.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    String firstName;
    String lastName;
    String email;
    LocalDate dateOfBirth;
    Long id;
}
