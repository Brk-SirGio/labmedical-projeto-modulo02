package com.labmedical.Controllers;

import com.labmedical.Dto.ConsultaDTO;
import com.labmedical.Entities.Consulta;
import com.labmedical.Services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> criarConsulta(@Valid @RequestBody ConsultaDTO consultaDTO) {
        ConsultaDTO consultaCriada = consultaService.criarConsulta(consultaDTO);
        return new ResponseEntity<>(consultaCriada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> obterConsultaPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.obterConsultaPorId(id);
        ConsultaDTO consultaDTO = new ConsultaDTO(
                consulta.getMotivoConsulta(),
                consulta.getDataConsulta(),
                consulta.getHorarioConsulta(),
                consulta.getDescricaoProblema(),
                consulta.getMedicacaoReceitada(),
                consulta.getDosagemPrecaucoes(),
                consulta.getPaciente().getId()
        );
        return ResponseEntity.ok(consultaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> atualizarConsulta(@PathVariable Long id, @RequestBody @Valid ConsultaDTO consultaDTO) {
        Consulta consultaAtualizada = consultaService.atualizarConsulta(id, consultaDTO);
        ConsultaDTO consultaDTOResponse = new ConsultaDTO(
                consultaAtualizada.getMotivoConsulta(),
                consultaAtualizada.getDataConsulta(),
                consultaAtualizada.getHorarioConsulta(),
                consultaAtualizada.getDescricaoProblema(),
                consultaAtualizada.getMedicacaoReceitada(),
                consultaAtualizada.getDosagemPrecaucoes(),
                consultaAtualizada.getPaciente().getId()
        );
        return ResponseEntity.ok(consultaDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}

