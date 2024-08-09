package br.com.fiap.gerenciamentotrafego.dto;

import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.model.Rua;
import br.com.fiap.gerenciamentotrafego.model.Veiculo;

import java.time.LocalDate;
import java.util.List;

public record AcidenteExibicaoDTO(
        String idAcidente,
        LocalDate dataHora,
        String gravidade,
        String localizacao,
        List<Veiculo> veiculos,
        Rua rua
) {

    public AcidenteExibicaoDTO(Acidente acidente){
        this(
                acidente.getIdAcidente(),
                acidente.getDataHora(),
                acidente.getGravidade(),
                acidente.getLocalizacao(),
                acidente.getVeiculos(),
                acidente.getRua()
        );

    }
}
