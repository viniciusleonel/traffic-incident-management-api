package br.com.fiap.gerenciamentotrafego.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_clima")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Clima {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CLIMA"
    )
    @SequenceGenerator(
            name = "SEQ_CLIMA",
            sequenceName = "SEQ_CLIMA",
            allocationSize = 20
    )
    @Column(name = "id_clima")
    private Long idClima;

    @Column(name = "id_localizacao")
    private Long idLocalizacao;

}
