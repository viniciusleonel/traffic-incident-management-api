package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.RuaCadastroDTO;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;

//@Entity
//@Table(name = "tbl_rua")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Rua {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID_Rua")
//    private Long idRua;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "cidade", length = 20, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    public Rua(RuaCadastroDTO rua) {
        this.logradouro = rua.logradouro();
        this.numero = rua.numero();
        this.cep = rua.cep();
        this.cidade = rua.cidade();
        this.estado = rua.estado();
    }
}
