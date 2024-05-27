package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_viagens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Viagens {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_VIAGENS"
    )
    @SequenceGenerator(
            name = "SEQ_VIAGENS",
            sequenceName = "SEQ_VIAGENS",
            allocationSize = 20
    )
    @Column(name = "id_viagem")
    private Long idViagens;

    @Column(name = "distancia", nullable = false)
    private Integer distancia;

    @Column(name = "vel_trafego", nullable = false)
    private Integer velTrafego;

}

