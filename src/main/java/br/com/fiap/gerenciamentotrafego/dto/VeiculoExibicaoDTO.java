package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;

public record VeiculoExibicaoDTO(
        String id,
        String adicenteId,
        String placa,
        String modelo,
        Integer ano,
        String cor
) {
    public VeiculoExibicaoDTO (Veiculo veiculo){
        this(
                Optional.ofNullable(veiculo.getId()).orElse(""),
                Optional.ofNullable(veiculo.getAcidenteId()).orElse(""),
                Optional.ofNullable(veiculo.getPlaca()).orElse(""),
                Optional.ofNullable(veiculo.getModelo()).orElse(""),
                Optional.ofNullable(veiculo.getAno()).orElse(null),
                Optional.ofNullable(veiculo.getCor()).orElse("")
        );
    }
}
