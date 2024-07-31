package com.labmedical.Controllers;

import com.labmedical.Dto.UsuarioDTO;
import com.labmedical.Entities.Usuario;
import com.labmedical.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuarioCriado = usuarioService.criarUsuario(usuarioDTO);
            return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obterTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obterTodosUsuarios();
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getCpf(),
                        usuario.getPassword(),
                        usuario.getDataNascimento(),
                        usuario.getUsername(),
                        usuario.getPerfil().name()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }
}
