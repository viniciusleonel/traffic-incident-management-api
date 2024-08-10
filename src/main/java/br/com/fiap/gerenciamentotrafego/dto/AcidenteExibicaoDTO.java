package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Acidente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record AcidenteExibicaoDTO(
        String idAcidente,
        LocalDateTime dataHora,
        String gravidade,
        EnderecoExibicaoDTO endereco,
        List<VeiculoExibicaoDTO> veiculos,
        List<FeridoExibicaoDTO> feridos
) {

    public AcidenteExibicaoDTO(Acidente acidente){
        this(
                Optional.ofNullable(acidente.getId()).orElse(""),
                acidente.getDataHora(),
                Optional.ofNullable(acidente.getGravidade()).orElse(""),
                Optional.ofNullable(acidente.getEndereco()).map(EnderecoExibicaoDTO::new).orElse(null),
                Optional.ofNullable(acidente.getVeiculos()).orElse(List.of()).stream().map(VeiculoExibicaoDTO::new).collect(Collectors.toList()),
                Optional.ofNullable(acidente.getFeridos()).orElse(List.of()).stream().map(FeridoExibicaoDTO::new).collect(Collectors.toList())
        );
    }
}