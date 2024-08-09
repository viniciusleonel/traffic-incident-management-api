package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;

import java.util.Optional;

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
                veiculo.getAno(),
                Optional.ofNullable(veiculo.getCor()).orElse("")
        );
    }
}
