package com.gthsoftware.casino.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "Users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="CUST_SEQ")
    private Long id;

    @Column(name = "firstName", length = 1000, nullable = false)
    String firstName;
    @Column(name = "lastName", length = 1000, nullable = false)
    String lastName;
    @Column(name = "email", length = 1000, nullable = false)
    String email;
    @Column(name = "dateOfBirth", nullable = false)
    LocalDate dateOfBirth;

}
