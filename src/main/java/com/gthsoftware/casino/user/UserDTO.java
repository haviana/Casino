package com.gthsoftware.casino.user;

import java.time.LocalDate;


public record  UserDTO (
    String firstName,
    String lastName,
    String email,
    LocalDate dateOfBirth,
    Long id){}
