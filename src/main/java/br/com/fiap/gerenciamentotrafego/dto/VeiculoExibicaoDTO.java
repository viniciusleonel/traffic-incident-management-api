package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;

public record VeiculoExibicaoDTO(
        Long idVeiculo,
        String placa,
        String modelo,
        Integer ano,
        String cor
) {
    public VeiculoExibicaoDTO (Veiculo veiculo){
        this(
                veiculo.getIdVeiculo(),
                veiculo.getPlaca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor()
        );
    }
}
