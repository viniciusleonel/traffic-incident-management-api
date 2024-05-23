package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.model.Rua;
import br.com.fiap.gerenciamentotrafego.model.Veiculo;

import java.time.LocalDate;

public record AcidenteExibicaoDTO(
        Long idAcidente,
        LocalDate dataHora,
        String gravidade,
        String localizacao,
        Veiculo veiculo,
        Rua rua
) {

    public AcidenteExibicaoDTO(Acidente acidente){
        this(
                acidente.getIdAcidente(),
                acidente.getDataHora(),
                acidente.getGravidade(),
                acidente.getLocalizacao(),
                acidente.getVeiculo(),
                acidente.getRua()
        );

    }
}
