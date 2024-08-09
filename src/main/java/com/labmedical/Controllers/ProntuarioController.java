package com.labmedical.Controllers;

import com.labmedical.Dto.ProntuarioDTO;
import com.labmedical.Services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<ProntuarioDTO> obterProntuarioDoPaciente(@PathVariable Long id) {
        ProntuarioDTO prontuarioDTO = prontuarioService.listarProntuarioDoPaciente(id);
        return ResponseEntity.ok(prontuarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDTO>> listarTodosProntuarios() {
        List<ProntuarioDTO> prontuarios = prontuarioService.listarTodosProntuarios();
        if (prontuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(prontuarios);
        }
        return ResponseEntity.ok(prontuarios);
    }
}
