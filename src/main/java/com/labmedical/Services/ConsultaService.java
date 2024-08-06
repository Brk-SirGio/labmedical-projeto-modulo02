package com.labmedical.Services;

import com.labmedical.Dto.ConsultaDTO;
import com.labmedical.Entities.Consulta;
import com.labmedical.Entities.Paciente;
import com.labmedical.Exceptions.ResourceNotFoundException;
import com.labmedical.Repositories.ConsultaRepository;
import com.labmedical.Repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public ConsultaDTO criarConsulta(ConsultaDTO consultaDTO) {
        // Verifique se o paciente existe
        Paciente paciente = pacienteRepository.findById(consultaDTO.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID: " + consultaDTO.getIdPaciente()));

        // Crie a nova consulta
        Consulta consulta = new Consulta();
        consulta.setMotivoConsulta(consultaDTO.getMotivoConsulta());
        consulta.setDataConsulta(consultaDTO.getDataConsulta());
        consulta.setHorarioConsulta(consultaDTO.getHorarioConsulta());
        consulta.setDescricaoProblema(consultaDTO.getDescricaoProblema());
        consulta.setMedicacaoReceitada(consultaDTO.getMedicacaoReceitada());
        consulta.setDosagemPrecaucoes(consultaDTO.getDosagemPrecaucoes());
        consulta.setPaciente(paciente);

        consulta = consultaRepository.save(consulta);

        return new ConsultaDTO(
                consulta.getMotivoConsulta(),
                consulta.getDataConsulta(),
                consulta.getHorarioConsulta(),
                consulta.getDescricaoProblema(),
                consulta.getMedicacaoReceitada(),
                consulta.getDosagemPrecaucoes(),
                consulta.getPaciente().getId()
        );
    }

    public Consulta obterConsultaPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
    }

    public Consulta atualizarConsulta(Long id, ConsultaDTO consultaDTO) {
        Consulta consultaExistente = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        Paciente paciente = pacienteRepository.findById(consultaDTO.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com ID: " + consultaDTO.getIdPaciente()));

        consultaExistente.setMotivoConsulta(consultaDTO.getMotivoConsulta());
        consultaExistente.setDataConsulta(consultaDTO.getDataConsulta());
        consultaExistente.setHorarioConsulta(consultaDTO.getHorarioConsulta());
        consultaExistente.setDescricaoProblema(consultaDTO.getDescricaoProblema());
        consultaExistente.setMedicacaoReceitada(consultaDTO.getMedicacaoReceitada());
        consultaExistente.setDosagemPrecaucoes(consultaDTO.getDosagemPrecaucoes());
        consultaExistente.setPaciente(paciente);

        return consultaRepository.save(consultaExistente);
    }

    public void deletarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        consultaRepository.delete(consulta);
    }
}

