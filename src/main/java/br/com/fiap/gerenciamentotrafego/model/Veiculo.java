package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "tbl_veiculos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Veiculo")
    private Long idVeiculo;

    @Column(name = "Placa", length = 7, nullable = false)
    @Positive
    private String placa;

    @Column(name = "Modelo", length = 100, nullable = false)
    private String modelo;

//    @Enumerated(EnumType.STRING)
    @Column(name = "Ano", nullable = false)
    private Integer ano;

    @Column(name = "Cor", length = 50, nullable = false)
    private String cor;

}

