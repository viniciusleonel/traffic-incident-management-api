package br.com.fiap.gerenciamentotrafego.dto;

public record VeiculoCadastroDTO(
        Long idVeiculo,
        String placa,
        String modelo,
        Integer ano,
        String cor
) {
}
