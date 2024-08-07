package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.RuaCadastroDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rua {

    @Field
    private String logradouro;

    @Field
    private Integer numero;

    @Field
    private String cep;

    @Field
    private String cidade;

    @Field
    private String estado;

    public Rua(RuaCadastroDTO rua) {
        this.logradouro = rua.logradouro();
        this.numero = rua.numero();
        this.cep = rua.cep();
        this.cidade = rua.cidade();
        this.estado = rua.estado();
    }
}
