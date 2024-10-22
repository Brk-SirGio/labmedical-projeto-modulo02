package com.labmedical.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 8, max = 64)
    private String motivoConsulta;

    @NotNull
    private LocalDate dataConsulta;

    @NotNull
    private LocalTime horarioConsulta;

    @NotBlank
    @Size(min = 16, max = 1024)
    private String descricaoProblema;

    private String medicacaoReceitada;

    @Size(min = 16, max = 256)
    private String dosagemPrecaucoes;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}

