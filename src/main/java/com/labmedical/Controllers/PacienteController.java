package com.labmedical.Controllers;

import com.labmedical.Dto.PacienteDTO;
import com.labmedical.Entities.Paciente;
import com.labmedical.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<?> criarPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
        try {
            Paciente pacienteCriado = pacienteService.criarPaciente(pacienteDTO);
            return new ResponseEntity<>(pacienteCriado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO pacienteAtualizado = pacienteService.atualizarPaciente(id, pacienteDTO);
        return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> obterPacientePorId(@PathVariable Long id) {
        PacienteDTO pacienteDTO = pacienteService.obterPacientePorId(id);
        return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<PacienteDTO>> obterTodosPacientes() {
        List<Paciente> pacientes = pacienteService.obterTodosPacientes();
        List<PacienteDTO> pacientesDTO = pacientes.stream()
                .map(paciente -> new PacienteDTO(
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
                        paciente.getEndereco()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(pacientesDTO, HttpStatus.OK);
    }


}
