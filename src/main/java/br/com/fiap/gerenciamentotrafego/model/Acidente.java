package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.model.Rua;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_acidente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Acidente")
    private Long idAcidente;

    @ManyToOne
    @JoinColumn(name = "ID_Veiculo", referencedColumnName = "ID_Veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "ID_Rua", referencedColumnName = "ID_Rua", nullable = false)
    private Rua rua;

    @Column(name = "Data_Hora", length = 10, nullable = false)
    private LocalDate dataHora;

    @Column(name = "Gravidade", length = 50, nullable = false)
    private String gravidade;

    @Column(name = "Localizacao", length = 100, nullable = false)
    private String localizacao;
}
