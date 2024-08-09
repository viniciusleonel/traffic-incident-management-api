package br.com.fiap.gerenciamentotrafego.dto;

import java.util.Optional;

import br.com.fiap.gerenciamentotrafego.model.Ferido;

public record FeridoExibicaoDTO(
        String id,
        String acidenteId,
        String nome,
        String cpf,
        String gravidade,
        String placaVeiculo
) {

    public FeridoExibicaoDTO(Ferido ferido) {
        this(
                Optional.ofNullable(ferido.getId()).orElse(""),
                Optional.ofNullable(ferido.getAcidenteId()).orElse(""),
                Optional.ofNullable(ferido.getNome()).orElse(""),
                Optional.ofNullable(ferido.getCpf()).orElse(""),
                Optional.ofNullable(ferido.getGravidade()).orElse(""),
                Optional.ofNullable(ferido.getPlacaVeiculo()).orElse("")
        );
    }
}