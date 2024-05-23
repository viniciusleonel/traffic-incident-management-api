//package br.com.fiap.gerenciamentotrafego.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Positive;
//import lombok.*;
//import org.antlr.v4.runtime.misc.NotNull;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "tbl_veiculos")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//
//public class Veiculo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_Veiculo")
//    private Long idVeiculo;
//
//    @Column(name = "Placa")
//    @NotNull
//    @Positive
//    private String placa;
//
//    @Column(name = "Modelo")
//    private String modelo;
//
////    @Enumerated(EnumType.STRING)
//    @Column(name = "Ano")
//    private Integer ano;
//
//    @Column(name = "Cor")
//    private String cor;
//
//}
//
