package com.labmedical.Entities;

import com.labmedical.Enums.Perfil;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String nome;

    @NotBlank
    @Email
    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(length = 14, nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String password;

    @Past
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotBlank
    @Column(length = 255, nullable = false, unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;
}
