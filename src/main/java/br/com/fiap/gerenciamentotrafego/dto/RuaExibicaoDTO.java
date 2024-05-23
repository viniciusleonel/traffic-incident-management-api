package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Rua;

public record RuaExibicaoDTO(
        Long idRua,
        String logradouro,
        Integer numero,
        String cep,
        String cidade,
        String estado
) {
    public RuaExibicaoDTO (Rua rua){
        this(
             rua.getIdRua(),
             rua.getLogradouro(),
             rua.getNumero(),
             rua.getCep(),
             rua.getCidade(),
             rua.getEstado()
        );
    }
}
