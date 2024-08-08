package com.labmedical.Services;

import com.labmedical.Dto.ExameDTO;
import com.labmedical.Entities.Exame;
import com.labmedical.Entities.Paciente;
import com.labmedical.Repositories.ExameRepository;
import com.labmedical.Repositories.PacienteRepository;
import com.labmedical.Exceptions.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    private final ExameRepository exameRepository;
    private final PacienteRepository pacienteRepository;

    public ExameService(ExameRepository exameRepository, PacienteRepository pacienteRepository) {
        this.exameRepository = exameRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Exame criarExame(ExameDTO exameDTO) {
        Paciente paciente = pacienteRepository.findById(exameDTO.getIdPaciente())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID " + exameDTO.getIdPaciente()));

        Exame exame = new Exame();
        exame.setNomeExame(exameDTO.getNomeExame());
        exame.setDataExame(exameDTO.getDataExame());
        exame.setHorarioExame(exameDTO.getHorarioExame());
        exame.setTipoExame(exameDTO.getTipoExame());
        exame.setLaboratorio(exameDTO.getLaboratorio());
        exame.setUrlDocumento(exameDTO.getUrlDocumento());
        exame.setResultados(exameDTO.getResultados());
        exame.setPaciente(paciente);

        return exameRepository.save(exame);
    }

    public Exame obterExamePorId(Long id) {
        return exameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado com o ID " + id));
    }

    public Exame atualizarExame(Long id, ExameDTO exameDTO) {
        Exame exame = obterExamePorId(id);
        exame.setNomeExame(exameDTO.getNomeExame());
        exame.setDataExame(exameDTO.getDataExame());
        exame.setHorarioExame(exameDTO.getHorarioExame());
        exame.setTipoExame(exameDTO.getTipoExame());
        exame.setLaboratorio(exameDTO.getLaboratorio());
        exame.setUrlDocumento(exameDTO.getUrlDocumento());
        exame.setResultados(exameDTO.getResultados());

        return exameRepository.save(exame);
    }

    public void excluirExame(Long id) {
        Exame exame = obterExamePorId(id);
        exameRepository.delete(exame);
    }

    public List<Exame> obterTodosExames() {
        return exameRepository.findAll();
    }
}
