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
                veiculo.getId(),
                veiculo.getAcidenteId(),
                veiculo.getPlaca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor()
        );
    }
}
