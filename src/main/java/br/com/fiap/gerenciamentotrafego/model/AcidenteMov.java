package br.com.fiap.gerenciamentotrafego.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "acidentes_mov")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAcidenteMov")
public class AcidenteMov {

    @Id
    private String idAcidenteMov;

    @Field
    private LocalDate dataHora;

    @Field
    private String operacao;

    @Field
    private String gravidade;
}
