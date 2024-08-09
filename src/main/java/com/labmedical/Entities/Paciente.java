package com.labmedical.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    private String telefone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 64)
    private String naturalidade;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    private String contatoEmergencia;

    @ElementCollection
    private List<String> alergias;

    @ElementCollection
    private List<String> cuidadosEspecificos;

    private String convenio;
    private String numeroConvenio;
    private LocalDate validadeConvenio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "paciente")
    private List<Exame> exames;
}
