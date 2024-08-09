package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RuaCadastroDTO(

        String idAcidente,

        @NotBlank(message = "Insira um logradouro!")
        String logradouro,

        @NotNull(message = "Insira um número!")
        Integer numero,

        @NotBlank
        @Pattern(regexp = "\\d{8}", message = "Insira um número de CEP válido no formato xxxxxxxx!")
        String cep,

        @NotBlank(message = "Insira uma cidade!")
        String cidade,

        @NotBlank(message = "Insira um estado!")
        String estado
) {
}
