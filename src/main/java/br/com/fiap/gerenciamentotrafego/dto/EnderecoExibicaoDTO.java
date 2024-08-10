package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Endereco;

import java.util.Optional;

public record EnderecoExibicaoDTO(
        String logradouro,
        String bairro,
        Integer numero,
        String cep,
        String cidade,
        String estado
) {
    public EnderecoExibicaoDTO(Endereco rua){
        this(
            Optional.ofNullable(rua.getLogradouro()).orElse(""),
            Optional.ofNullable(rua.getBairro()).orElse(""),
            rua.getNumero(),
            Optional.ofNullable(rua.getCep()).orElse(""),
            Optional.ofNullable(rua.getCidade()).orElse(""),
            Optional.ofNullable(rua.getEstado()).orElse("")
        );
    }
}
