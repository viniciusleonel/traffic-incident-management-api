package br.com.fiap.gerenciamentotrafego.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEstrada")
public class Estrada {

    @Id
    private String idEstrada;

    @Field
    private Integer velocidadeMax;

    @Field
    private Date hora;

    @Field
    private String nomeEstrada;

}
