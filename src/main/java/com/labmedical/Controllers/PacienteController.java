package com.labmedical.Controllers;

import com.labmedical.Dto.PacienteDTO;
import com.labmedical.Entities.Paciente;
import com.labmedical.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody @Validated PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.criarPaciente(pacienteDTO);
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
    }
}
