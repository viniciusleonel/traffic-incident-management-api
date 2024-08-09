package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Rua;

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
            Optional.ofNullable(rua.getNumero()).orElse(null),
            Optional.ofNullable(rua.getCep()).orElse(""),
            Optional.ofNullable(rua.getCidade()).orElse(""),
            Optional.ofNullable(rua.getEstado()).orElse("")
        );
    }
}
