package com.labmedical.Services;

import java.util.NoSuchElementException;
import com.labmedical.Dto.PacienteDTO;
import com.labmedical.Entities.Paciente;
import com.labmedical.Entities.Usuario;
import com.labmedical.Enums.Perfil;
import com.labmedical.Exceptions.ResourceNotFoundException;
import com.labmedical.Exceptions.UsuarioDuplicadoException;
import com.labmedical.Repositories.PacienteRepository;
import com.labmedical.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public Paciente criarPaciente(PacienteDTO pacienteDTO) {

        // Verifica se já existe um usuário com o CPF fornecido
        if (usuarioRepository.existsByCpf(pacienteDTO.getCpf())) {
            throw new UsuarioDuplicadoException("CPF já cadastrado!");
        }

        // Criar um novo usuário
        Usuario usuario = new Usuario();
        usuario.setCpf(pacienteDTO.getCpf());
        usuario.setNome(pacienteDTO.getNomeCompleto());
        usuario.setDataNascimento(pacienteDTO.getDataNascimento());
        usuario.setEmail(pacienteDTO.getEmail());
        usuario.setPassword("senhaSegura123"); // Defina uma senha padrão ou gere uma senha adequada
        usuario.setPerfil(Perfil.PACIENTE); // Definir o perfil como PACIENTE
        usuario.setUsername(pacienteDTO.getCpf()); // Ou outro campo único, por exemplo, pacienteDTO.getEmail()

        // Salvar o usuário
        usuario = usuarioRepository.save(usuario);

        // Criar o paciente
        Paciente paciente = new Paciente();
        paciente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setRg(pacienteDTO.getRg());
        paciente.setOrgaoExpedidor(pacienteDTO.getOrgaoExpedidor());
        paciente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setNaturalidade(pacienteDTO.getNaturalidade());
        paciente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        paciente.setAlergias(pacienteDTO.getAlergias());
        paciente.setCuidadosEspecificos(pacienteDTO.getCuidadosEspecificos());
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        paciente.setValidadeConvenio(pacienteDTO.getValidadeConvenio());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setUsuario(usuario); // Associar o usuário criado ao paciente

        // Salvar o paciente
        return pacienteRepository.save(paciente);
    }

    public PacienteDTO atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID: " + id));

        // Atualizar os campos do paciente existente
        pacienteExistente.setNomeCompleto(pacienteDTO.getNomeCompleto());
        pacienteExistente.setGenero(pacienteDTO.getGenero());
        pacienteExistente.setDataNascimento(pacienteDTO.getDataNascimento());
        pacienteExistente.setCpf(pacienteDTO.getCpf());
        pacienteExistente.setRg(pacienteDTO.getRg());
        pacienteExistente.setOrgaoExpedidor(pacienteDTO.getOrgaoExpedidor());
        pacienteExistente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        pacienteExistente.setTelefone(pacienteDTO.getTelefone());
        pacienteExistente.setEmail(pacienteDTO.getEmail());
        pacienteExistente.setNaturalidade(pacienteDTO.getNaturalidade());
        pacienteExistente.setContatoEmergencia(pacienteDTO.getContatoEmergencia());
        pacienteExistente.setAlergias(pacienteDTO.getAlergias());
        pacienteExistente.setCuidadosEspecificos(pacienteDTO.getCuidadosEspecificos());
        pacienteExistente.setConvenio(pacienteDTO.getConvenio());
        pacienteExistente.setNumeroConvenio(pacienteDTO.getNumeroConvenio());
        pacienteExistente.setValidadeConvenio(pacienteDTO.getValidadeConvenio());
        pacienteExistente.setEndereco(pacienteDTO.getEndereco());

        Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);

        // Retornar o DTO do paciente atualizado
        return new PacienteDTO(
                pacienteAtualizado.getNomeCompleto(),
                pacienteAtualizado.getGenero(),
                pacienteAtualizado.getDataNascimento(),
                pacienteAtualizado.getCpf(),
                pacienteAtualizado.getRg(),
                pacienteAtualizado.getOrgaoExpedidor(),
                pacienteAtualizado.getEstadoCivil(),
                pacienteAtualizado.getTelefone(),
                pacienteAtualizado.getEmail(),
                pacienteAtualizado.getNaturalidade(),
                pacienteAtualizado.getContatoEmergencia(),
                pacienteAtualizado.getAlergias(),
                pacienteAtualizado.getCuidadosEspecificos(),
                pacienteAtualizado.getConvenio(),
                pacienteAtualizado.getNumeroConvenio(),
                pacienteAtualizado.getValidadeConvenio(),
                pacienteAtualizado.getUsuario().getId(),
                pacienteAtualizado.getEndereco()
        );
    }



    public void deletarPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID: " + id));
        pacienteRepository.delete(paciente);
    }


    public PacienteDTO obterPacientePorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID: " + id));

        return new PacienteDTO(
                paciente.getNomeCompleto(),
                paciente.getGenero(),
                paciente.getDataNascimento(),
                paciente.getCpf(),
                paciente.getRg(),
                paciente.getOrgaoExpedidor(),
                paciente.getEstadoCivil(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getNaturalidade(),
                paciente.getContatoEmergencia(),
                paciente.getAlergias(),
                paciente.getCuidadosEspecificos(),
                paciente.getConvenio(),
                paciente.getNumeroConvenio(),
                paciente.getValidadeConvenio(),
                paciente.getUsuario().getId(),
                paciente.getEndereco()
        );
    }


    public List<Paciente> obterTodosPacientes() {
        return pacienteRepository.findAll();
    }



}
