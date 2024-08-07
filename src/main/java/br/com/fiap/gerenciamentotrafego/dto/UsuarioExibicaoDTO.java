package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Usuario;
import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;

public record UsuarioExibicaoDTO (String id, String email, UsuarioRole role) {

    public UsuarioExibicaoDTO(Usuario usuario){
        this(usuario.getIdUsuario(), usuario.getEmail(), usuario.getRole());
    }
}