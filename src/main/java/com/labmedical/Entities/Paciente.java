package com.labmedical.Entities;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 8, max = 64)
    @Column(nullable = false)
    private String nomeCompleto;

    @NotBlank
    @Column(nullable = false)
    private String genero;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false)
    private String rg;

    @NotBlank
    @Column(nullable = false)
    private String orgaoExpedidor;

    @NotBlank
    @Column(nullable = false)
    private String estadoCivil;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) 9 \\d{4}-\\d{4}")
    @Column(nullable = false)
    private String telefone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 64)
    @Column(nullable = false)
    private String naturalidade;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\) 9 \\d{4}-\\d{4}")
    @Column(nullable = false)
    private String contatoEmergencia;

    @ElementCollection
    private List<String> alergias;

    @ElementCollection
    private List<String> cuidadosEspecificos;

    private String convenio;
    private String numeroConvenio;
    private LocalDate validadeConvenio;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
