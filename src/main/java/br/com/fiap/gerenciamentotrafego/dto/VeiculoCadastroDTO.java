package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoCadastroDTO(

        String id,
        String idAcidente,
        String placa,
        String modelo,
        Integer ano,
        String cor
) {
}
