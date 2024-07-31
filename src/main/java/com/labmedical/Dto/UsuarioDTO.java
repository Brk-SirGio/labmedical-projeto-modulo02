package com.labmedical.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nome;
    private String email;
    private String cpf;
    private String password;
    private LocalDate dataNascimento;
    private String username;
    private String perfil;
}
