package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_acidente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acidente")
    private Long idAcidente;

//    @ManyToOne
//    @JoinColumn(name = "ID_Veiculo", referencedColumnName = "ID_Veiculo", nullable = false)
    private Veiculo veiculo;

//    @ManyToOne
//    @JoinColumn(name = "ID_Rua", referencedColumnName = "ID_Rua", nullable = false)
    private Rua rua;

    @Column(name = "data_Hora",  nullable = false)
    private LocalDate dataHora;

    @Column(name = "gravidade", length = 50, nullable = false)
    private String gravidade;

    @Column(name = "localizacao", length = 100, nullable = false)
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
