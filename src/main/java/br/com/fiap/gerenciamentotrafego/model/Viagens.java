package br.com.fiap.gerenciamentotrafego.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "viagens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idViagens")
public class Viagens {

    @Id
    private String idViagens;

    @Field
    private Integer distancia;

    @Field
    private Integer velTrafego;

}

