package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "acidentes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAcidente")
public class Acidente {

    @Id
    private String idAcidente;

    @Field
    private Veiculo veiculo;

    @Field
    private Rua rua;

    @Field
    private LocalDate dataHora;

    @Field
    private String gravidade;

    @Field
    private String localizacao;

    public Acidente(AcidenteCadastroDTO dados) {
        this.veiculo = new Veiculo(dados.veiculo());
        this.rua = new Rua(dados.rua());
        this.dataHora = dados.dataHora();
        this.gravidade = dados.gravidade();
        this.localizacao = dados.localizacao();
    }

    public void atualizarInformacoes(AcidenteCadastroDTO dados) {
        if (dados.veiculo() != null) {
            this.veiculo = new Veiculo(dados.veiculo());
        }
        if (dados.rua() != null) {
            this.rua = new Rua(dados.rua());
        }
        if (dados.dataHora() != null) {
            this.dataHora = dados.dataHora();
        }
        if (dados.gravidade() != null) {
            this.gravidade = dados.gravidade();
        }
        if (dados.dataHora() != null) {
            this.localizacao = dados.localizacao();
        }


    }
}
