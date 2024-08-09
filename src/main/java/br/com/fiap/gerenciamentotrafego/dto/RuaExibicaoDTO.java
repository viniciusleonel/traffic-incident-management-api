package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Rua;

import java.util.Optional;

public record RuaExibicaoDTO(
        String logradouro,
        Integer numero,
        String cep,
        String cidade,
        String estado
) {
    public RuaExibicaoDTO (Rua rua){
        this(
            Optional.ofNullable(rua.getLogradouro()).orElse(""),
            rua.getNumero(),
            Optional.ofNullable(rua.getCep()).orElse(""),
            Optional.ofNullable(rua.getCidade()).orElse(""),
            Optional.ofNullable(rua.getEstado()).orElse("")
        );
    }
}
