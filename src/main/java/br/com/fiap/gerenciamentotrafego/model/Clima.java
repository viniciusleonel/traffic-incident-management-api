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

//    CREATE TABLE clima (
//    id_clima VARCHAR2(10),
//    id_localizacao NUMBER);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clima")
    private Long idClima;

    @Column(name = "id_localizacao")
    private Long idLocalizacao;

}
