package com.labmedical.Services;

import com.labmedical.Dto.ConsultaDTO;
import com.labmedical.Dto.ExameDTO;
import com.labmedical.Dto.ProntuarioDTO;
import com.labmedical.Entities.Paciente;
import com.labmedical.Exceptions.ResourceNotFoundException;
import com.labmedical.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProntuarioService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public ProntuarioDTO listarProntuarioDoPaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + pacienteId));

        ProntuarioDTO prontuarioDTO = new ProntuarioDTO(
                paciente.getId(),
                paciente.getNomeCompleto(),
                paciente.getConvenio(),
                paciente.getContatoEmergencia(),
                paciente.getAlergias(),
                paciente.getCuidadosEspecificos(),
                paciente.getConsultas().stream()
                        .map(consulta -> new ConsultaDTO(
                                consulta.getMotivoConsulta(),
                                consulta.getDataConsulta(),
                                consulta.getHorarioConsulta(),
                                consulta.getDescricaoProblema(),
                                consulta.getMedicacaoReceitada(),
                                consulta.getDosagemPrecaucoes(),
                                consulta.getPaciente().getId()))
                        .collect(Collectors.toList()),
                paciente.getExames().stream()
                        .map(exame -> new ExameDTO(
                                exame.getNomeExame(),
                                exame.getDataExame(),
                                exame.getHorarioExame(),
                                exame.getTipoExame(),
                                exame.getLaboratorio(),
                                exame.getUrlDocumento(),
                                exame.getResultados(),
                                exame.getPaciente().getId()))
                        .collect(Collectors.toList())
        );

        return prontuarioDTO;
    }

    public List<ProntuarioDTO> listarTodosProntuarios() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> new ProntuarioDTO(
                        paciente.getId(),
                        paciente.getNomeCompleto(),
                        paciente.getConvenio(),
                        paciente.getContatoEmergencia(),
                        paciente.getAlergias(),
                        paciente.getCuidadosEspecificos(),
                        paciente.getConsultas().stream().map(consulta -> new ConsultaDTO(
                                consulta.getMotivoConsulta(),
                                consulta.getDataConsulta(),
                                consulta.getHorarioConsulta(),
                                consulta.getDescricaoProblema(),
                                consulta.getMedicacaoReceitada(),
                                consulta.getDosagemPrecaucoes(),
                                consulta.getPaciente().getId()
                        )).collect(Collectors.toList()),
                        paciente.getExames().stream().map(exame -> new ExameDTO(
                                exame.getNomeExame(),
                                exame.getDataExame(),
                                exame.getHorarioExame(),
                                exame.getTipoExame(),
                                exame.getLaboratorio(),
                                exame.getUrlDocumento(),
                                exame.getResultados(),
                                exame.getPaciente().getId()
                        )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

}
