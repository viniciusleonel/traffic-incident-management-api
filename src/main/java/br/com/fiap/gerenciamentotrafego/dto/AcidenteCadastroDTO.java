package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AcidenteCadastroDTO(

        @NotNull(message = "Insira a data e a hora do acidente!")
        LocalDate dataHora,

        @NotBlank(message = "Insira a gravidade do acidente!")
        String gravidade,

        @NotBlank(message = "Insira a localização do acidente!")
        String localizacao,

        @NotNull(message = "Insira ao menos um veiculo!")
        @Valid
        List<VeiculoCadastroDTO> veiculos,

        @NotNull(message = "Insira uma rua!")
        @Valid
        RuaCadastroDTO rua
) {
}
