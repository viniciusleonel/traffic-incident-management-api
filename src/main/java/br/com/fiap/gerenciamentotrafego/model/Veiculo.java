package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.VeiculoCadastroDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

//@Entity
//@Table(name = "tbl_veiculos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Veiculo {

    @Column(name = "Placa", length = 8, nullable = false)
    private String placa;

    @Column(name = "Modelo", length = 100, nullable = false)
    private String modelo;

//    @Enumerated(EnumType.STRING)
    @Column(name = "Ano", nullable = false)
    @Positive
    private Integer ano;

    @Column(name = "Cor", length = 50, nullable = false)
    private String cor;

    public Veiculo(VeiculoCadastroDTO dados) {
        this.placa = dados.placa();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
    }
}

