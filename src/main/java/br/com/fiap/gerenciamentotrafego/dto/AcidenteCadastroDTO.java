package br.com.fiap.gerenciamentotrafego.dto;

import java.time.LocalDate;

public record AcidenteCadastroDTO(
        Long idAcidente,
        LocalDate dataHora,
        String gravidade,
        String localizacao
) {
}
