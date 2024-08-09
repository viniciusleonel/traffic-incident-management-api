package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.FeridoCadastroDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "feridos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ferido {

    @Id
    private String id;

    @Field
    private String nome;

    @Field
    private String cpf;

    @Field
    private String gravidade;

    @Setter
    @Field
    private String acidenteId;

    @Setter
    @Field
    private String placaVeiculo;

    public Ferido(FeridoCadastroDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.gravidade = dados.gravidade();
        this.acidenteId = dados.acidenteId();
        this.placaVeiculo = dados.veiculoId();
    }

}
