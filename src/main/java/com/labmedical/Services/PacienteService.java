package com.labmedical.Services;

import com.labmedical.Dto.PacienteDTO;
import com.labmedical.Entities.Paciente;
import com.labmedical.Repositories.PacienteRepository;
import com.labmedical.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Paciente criarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        paciente.setNaturalidade(pacienteDTO.getNaturalidade());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        paciente.setRg(pacienteDTO.getRg());
        paciente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setAlergias(pacienteDTO.getAlergias());
        paciente.setCuidadosEspecificos(pacienteDTO.getCuidadosEspecificos());
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        paciente.setValidadeConvenio(pacienteDTO.getValidadeConvenio());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setUsuario(usuarioRepository.findById(pacienteDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        return pacienteRepository.save(paciente);
    }
}
