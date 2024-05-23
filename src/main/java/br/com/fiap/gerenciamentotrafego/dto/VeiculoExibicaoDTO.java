package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;

public record VeiculoExibicaoDTO(
        String placa,
        String modelo,
        Integer ano,
        String cor
) {
    public VeiculoExibicaoDTO (Veiculo veiculo){
        this(
                veiculo.getPlaca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor()
        );
    }
}
