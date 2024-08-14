package com.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "username can not be null")
    @Length(min = 4,message = "username Length must be more than 4")
    private String username;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "password can not be null")
    private String password;


    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "email can not be null")
    @Email(message = "must be valid email ")
    private String email;

    @Column(columnDefinition = "Datetime")
    private LocalDate registrationDate;
}
