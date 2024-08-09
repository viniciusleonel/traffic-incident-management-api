package br.com.fiap.gerenciamentotrafego.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record AcidenteCadastroDTO(

        LocalDateTime dataHora,
        String gravidade,
        @Valid
        RuaCadastroDTO rua,
        @Valid
        List<VeiculoCadastroDTO> veiculos,
        @Valid
        List<FeridoCadastroDTO> feridos
) {
}
