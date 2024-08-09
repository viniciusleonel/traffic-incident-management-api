package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RuaCadastroDTO(

        String idAcidente,
        String logradouro,
        Integer numero,
        @Pattern(regexp = "\\d{8}", message = "Insira um número de CEP válido no formato xxxxxxxx!")
        String cep,
        String cidade,
        String estado
) {
}
