package br.com.fiap.gerenciamentotrafego;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.FeridoCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.RuaCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.VeiculoCadastroDTO;
import br.com.fiap.gerenciamentotrafego.service.AcidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class GerenciamentoTrafegoApplication implements CommandLineRunner {

    @Autowired
    private AcidenteService acidenteService;

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoTrafegoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        acidenteService.deletarTodosAcidentes();

        AcidenteCadastroDTO acidente = new AcidenteCadastroDTO(
            LocalDateTime.of(2024, 8, 4, 13, 0),
            "grave",
            new RuaCadastroDTO(null,"Rua das palmeiras", 123, "12345678", "Sao Paulo", "SP"),
            List.of(
                new VeiculoCadastroDTO(null, null,"fez-4111", "March", 2018, null),
                new VeiculoCadastroDTO(null, null,"tes-4789", "Versa", 2018, "Branco"),
                new VeiculoCadastroDTO(null, null,"htu-5872", "Onix", 2018, "Preto")
            ),
            List.of(
                new FeridoCadastroDTO(null, "Alfredo", null, "Costela fraturada", null, null),
                new FeridoCadastroDTO(null, "Marcelo", "12345678910", null, null, "htu-5872"),
                new FeridoCadastroDTO(null, null, "10987654321", null, null, null)
            )
        );

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        acidenteService.cadastrarNovoAcidente(acidente, uriBuilder);
    }
}