package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.Pattern;

public record EnderecoCadastroDTO(

        String idAcidente,
        String logradouro,
        String bairro,
        Integer numero,
        @Pattern(regexp = "\\d{8}", message = "Insira um número de CEP válido no formato xxxxxxxx!")
        String cep,
        String cidade,
        String estado
) {
}
