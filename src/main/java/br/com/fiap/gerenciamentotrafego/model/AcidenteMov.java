package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_acidente_mov")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AcidenteMov {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ACIDENTES_MOV"
    )
    @SequenceGenerator(
            name = "SEQ_ACIDENTES_MOV",
            sequenceName = "SEQ_ACIDENTES_MOV",
            allocationSize = 20
    )
    @Column(name = "id_acidentes_mov")
    private Long idAcidenteMov;

    @Column(name = "hora_mov", nullable = false)
    private LocalDate dataHora;

    @Column(name = "operacao", length = 9, nullable = false)
    private String operacao;

    @Column(name = "gravidade", length = 20, nullable = false)
    private String gravidade;
}
