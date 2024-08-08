package com.labmedical.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ExameDTO {

    @NotBlank
    @Size(min = 8, max = 64)
    private String nomeExame;

    @NotNull
    private LocalDate dataExame;

    @NotNull
    private LocalTime horarioExame;

    @NotBlank
    @Size(min = 4, max = 32)
    private String tipoExame;

    @NotBlank
    @Size(min = 4, max = 32)
    private String laboratorio;

    private String urlDocumento;

    @Size(min = 16, max = 1024)
    private String resultados;

    @NotNull
    private Long idPaciente;
}
