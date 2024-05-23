package br.com.fiap.gerenciamentotrafego.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(

        @NotBlank(message = "Insira um e-mail!")
        @Email(message = "Insira um e-mail válido!")
        String email,

        @NotBlank(message = "Insira uma senha!")
        String senha
) {
}
