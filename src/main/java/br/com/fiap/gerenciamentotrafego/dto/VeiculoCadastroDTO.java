package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoCadastroDTO(

        String id,

        String idAcidente,

        @NotBlank(message = "Insira uma placa!")
        String placa,

        @NotBlank(message = "Insira um modelo!")
        String modelo,

        @NotNull(message = "Insira um ano!")
        Integer ano,

        @NotBlank(message = "Insira uma cor!")
        String cor
) {
}
