package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Acidente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record AcidenteExibicaoDTO(
        String idAcidente,
        LocalDateTime dataHora,
        String gravidade,
        RuaExibicaoDTO rua,
        List<VeiculoExibicaoDTO> veiculos

) {

    public AcidenteExibicaoDTO(Acidente acidente){
        this(
                acidente.getId(),
                acidente.getDataHora(),
                acidente.getGravidade(),
                new RuaExibicaoDTO(acidente.getRua()),
                acidente.getVeiculos().stream().map(VeiculoExibicaoDTO::new).collect(Collectors.toList())

        );

    }
}
