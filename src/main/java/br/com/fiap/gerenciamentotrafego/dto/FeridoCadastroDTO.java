package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record FeridoCadastroDTO(

        String id,

        String nome,

        @Pattern(regexp = "^\\d{11}$", message = "CPF deve conter 11 digitos!")
        String cpf,

        String gravidade,

        String acidenteId,

        String veiculoId
) {
}



