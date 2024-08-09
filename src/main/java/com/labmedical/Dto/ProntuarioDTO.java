package com.labmedical.Dto;

import com.labmedical.Dto.ConsultaDTO;
import com.labmedical.Dto.ExameDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProntuarioDTO {
    private Long idPaciente;
    private String nomeCompleto;
    private String convenio;
    private String contatoEmergencia;
    private List<String> alergias;
    private List<String> cuidadosEspecificos;
    private List<ConsultaDTO> consultas;
    private List<ExameDTO> exames;
}
