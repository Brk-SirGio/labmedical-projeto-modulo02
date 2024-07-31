package com.labmedical.Services;

import com.labmedical.Dto.UsuarioDTO;
import com.labmedical.Entities.Usuario;
import com.labmedical.ENum.Perfil;
import com.labmedical.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        String perfilStr = usuarioDTO.getPerfil();
        if (perfilStr == null || !Perfil.isValid(perfilStr)) {
            throw new IllegalArgumentException("Perfil inválido: " + perfilStr);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPerfil(Perfil.valueOf(perfilStr.toUpperCase()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }
}
