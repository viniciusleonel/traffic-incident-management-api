package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.EnderecoCadastroDTO;
import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "enderecos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    private String id;

    @Setter
    @Field
    private String acidenteId;

    @Field
    private String logradouro;

    @Field
    private String bairro;

    @Field
    private Integer numero;

    @Field
    private String cep;

    @Field
    private String cidade;

    @Field
    private String estado;

    public Endereco(EnderecoCadastroDTO rua) {
        this.logradouro = rua.logradouro();
        this.bairro = rua.bairro();
        this.numero = rua.numero();
        this.cep = rua.cep();
        this.cidade = rua.cidade();
        this.estado = rua.estado();
    }
}
