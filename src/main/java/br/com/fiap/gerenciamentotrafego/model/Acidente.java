package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "acidentes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Acidente {

    @Id
    private String id;

    @Setter
    @Field
    private List<Veiculo> veiculos;

    @Field
    private Endereco endereco;

    @Field
    private LocalDateTime dataHora;

    @Field
    private String gravidade;

    @Field
    private List<Ferido> feridos;

    public Acidente(AcidenteCadastroDTO dados) {
        this.veiculos = dados.veiculos().stream().map(Veiculo::new).collect(Collectors.toList());
        this.endereco = new Endereco(dados.endereco());
        this.dataHora = dados.dataHora();
        this.gravidade = dados.gravidade();
        this.feridos = dados.feridos().stream().map(Ferido::new).collect(Collectors.toList());
    }

    public void atualizarInformacoes(AcidenteCadastroDTO dados) {
        if (dados.veiculos() != null) {
            this.veiculos = dados.veiculos().stream().map(Veiculo::new).collect(Collectors.toList());
        }
        if (dados.endereco() != null) {
            this.endereco = new Endereco(dados.endereco());
        }
        if (dados.dataHora() != null) {
            this.dataHora = dados.dataHora();
        }
        if (dados.gravidade() != null) {
            this.gravidade = dados.gravidade();
        }
        if (dados.feridos() != null) {
            this.feridos = dados.feridos().stream().map(Ferido::new).collect(Collectors.toList());
        }

    }
}
