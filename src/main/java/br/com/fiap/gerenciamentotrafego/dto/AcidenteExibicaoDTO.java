//package br.com.fiap.gerenciamentotrafego.dto;
//
//import br.com.fiap.gerenciamentotrafego.model.Acidente;
//import java.time.LocalDate;
//
//public record AcidenteExibicaoDTO(
//        Long idAcidente,
//        LocalDate dataHora,
//        String gravidade,
//        String localizacao
//) {
//
//    public AcidenteExibicaoDTO(Acidente acidente){
//        this(
//                acidente.getIdAcidente(),
//                acidente.getDataHora(),
//                acidente.getGravidade(),
//                acidente.getLocalizacao()
//        );
//
//    }
//}
