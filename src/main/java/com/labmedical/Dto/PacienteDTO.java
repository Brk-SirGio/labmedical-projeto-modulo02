package com.labmedical.Dto;

import com.labmedical.Entities.Endereco;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class PacienteDTO {

    @NotBlank
    @Size(min = 8, max = 64)
    private String nomeCompleto;

    @NotBlank
    private String genero;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    private String cpf;

    @NotBlank
    @Size(max = 20)
    private String rg;

    @NotBlank
    private String orgaoExpedidor;

    @NotBlank
    private String estadoCivil;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) 9 \\d{4}-\\d{4}")
    private String telefone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 64)
    private String naturalidade;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) 9 \\d{4}-\\d{4}")
    private String contatoEmergencia;

    private List<String> alergias;

    private List<String> cuidadosEspecificos;

    private String convenio;
    private String numeroConvenio;
    private LocalDate validadeConvenio;

    private Endereco endereco;

    @NotNull
    private Long usuarioId;
}
