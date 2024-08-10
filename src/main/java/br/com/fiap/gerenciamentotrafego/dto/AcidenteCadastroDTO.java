package br.com.fiap.gerenciamentotrafego.dto;


import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;

public record AcidenteCadastroDTO(

        LocalDateTime dataHora,
        String gravidade,
        @Valid
        EnderecoCadastroDTO endereco,
        @Valid
        List<VeiculoCadastroDTO> veiculos,
        @Valid
        List<FeridoCadastroDTO> feridos
) {
}
