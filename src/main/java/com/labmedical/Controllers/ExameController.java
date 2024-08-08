package com.labmedical.Controllers;

import com.labmedical.Dto.ExameDTO;
import com.labmedical.Entities.Exame;
import com.labmedical.Services.ExameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exames")
public class ExameController {

    private final ExameService exameService;

    public ExameController(ExameService exameService) {
        this.exameService = exameService;
    }

    @PostMapping
    public ResponseEntity<Exame> criarExame(@RequestBody ExameDTO exameDTO) {
        Exame novoExame = exameService.criarExame(exameDTO);
        return new ResponseEntity<>(novoExame, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exame> obterExamePorId(@PathVariable Long id) {
        Exame exame = exameService.obterExamePorId(id);
        return new ResponseEntity<>(exame, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exame> atualizarExame(@PathVariable Long id, @RequestBody ExameDTO exameDTO) {
        Exame exameAtualizado = exameService.atualizarExame(id, exameDTO);
        return new ResponseEntity<>(exameAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirExame(@PathVariable Long id) {
        exameService.excluirExame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Exame>> obterTodosExames() {
        List<Exame> exames = exameService.obterTodosExames();
        return new ResponseEntity<>(exames, HttpStatus.OK);
    }
}
