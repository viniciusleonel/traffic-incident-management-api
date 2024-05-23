//package br.com.fiap.gerenciamentotrafego.model;
//
//import br.com.fiap.gerenciamentotrafego.model.Rua;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.antlr.v4.runtime.misc.NotNull;
//
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "tbl_acidente")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//public class Acidente {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_Acidente")
//    private Long idAcidente;
//
//    @ManyToOne
//    @JoinColumn(name = "ID_Veiculo", referencedColumnName = "ID_Veiculo")
//    private Veiculo veiculo;
//
//    @ManyToOne
//    @JoinColumn(name = "ID_Rua", referencedColumnName = "ID_Rua")
//    private Rua rua;
//
//    @Column(name = "Data_Hora")
//    private LocalDate dataHora;
//
//    @Column(name = "Gravidade")
//    private String gravidade;
//
//    @Column(name = "Localizacao")
//    private String localizacao;
//}
