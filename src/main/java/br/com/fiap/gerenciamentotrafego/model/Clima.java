package br.com.fiap.gerenciamentotrafego.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "climas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idClima")
public class Clima {

    @Id
    private String idClima;

    @Field
    private Long idLocalizacao;

}
