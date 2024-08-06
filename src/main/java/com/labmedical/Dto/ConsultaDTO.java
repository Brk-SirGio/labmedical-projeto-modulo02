package com.labmedical.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ConsultaDTO {
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

    @Size(min = 7, max = 256)
    private String dosagemPrecaucoes;


    @NotNull
    private Long idPaciente;
}
