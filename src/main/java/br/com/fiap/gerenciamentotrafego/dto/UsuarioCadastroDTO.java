package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDTO(

        @NotBlank(message = "Insira um e-mail!")
        @Email(message = "Insira um e-mail válido!")
        String email,

        @NotBlank(message = "Insira uma senha!")
        String senha,

        @NotNull(message = "Insira um role!")
        UsuarioRole role){
}
