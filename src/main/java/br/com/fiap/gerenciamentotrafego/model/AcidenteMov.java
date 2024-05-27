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

//    CREATE TABLE acidente_mov (
//            id_acidente NUMBER,
//            hora_mov DATE,
//            operacao VARCHAR2(9),
//    gravidade VARCHAR2(20));

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acidente_mov")
    private Long idAcidenteMov;

    @Column(name = "hora_mov", nullable = false)
    private LocalDate dataHora;

    @Column(name = "operacao", length = 9, nullable = false)
    private String operacao;

    @Column(name = "gravidade", length = 20, nullable = false)
    private String gravidade;
}
