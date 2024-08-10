package br.com.fiap.gerenciamentotrafego;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.FeridoCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.EnderecoCadastroDTO;
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
            new EnderecoCadastroDTO(null,"Av. Lins de Vasconcelos","Aclimação", 1222, "12345678", "Sao Paulo", "SP"),
            List.of(
                new VeiculoCadastroDTO(null, null,"ABC-1234", "March", 2018, null),
                new VeiculoCadastroDTO(null, null,"DCE-5678", "Versa", 2018, "Branco"),
                new VeiculoCadastroDTO(null, null,"FGH-9I01", "Onix", null, "Preto")
            ),
            List.of(
                new FeridoCadastroDTO(null, "Alfredo", null, "Costela fraturada", null, null),
                new FeridoCadastroDTO(null, "Marcelo", "12345678910", null, null, "FGH-9I01"),
                new FeridoCadastroDTO(null, null, "10987654321", null, null, null)
            )
        );

        AcidenteCadastroDTO acidente2 = new AcidenteCadastroDTO(
                LocalDateTime.of(2024, 8, 8, 9, 0),
                "grave",
                new EnderecoCadastroDTO(null,"Av. Paulista ","Bela Vista", 1106, null, "Sao Paulo", null),
                List.of(
                        new VeiculoCadastroDTO(null, null,"IJK-0L12", "T-CROSS", 2018, null),
                        new VeiculoCadastroDTO(null, null,"LMN-3O45", null, 2018, "Vermelho"),
                        new VeiculoCadastroDTO(null, null,"OPQ-6R78", "Celta", 2018, "Cinza")
                ),
                List.of(
                        new FeridoCadastroDTO(null, "Paulo", null, "Pequenos arranhões", null, null),
                        new FeridoCadastroDTO(null, "José", "12345678910", null, null, "LMN-3O45"),
                        new FeridoCadastroDTO(null, null, "10987654321", null, null, null)
                )
        );

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        UriComponentsBuilder uriBuilder2 = UriComponentsBuilder.newInstance();
        acidenteService.cadastrarNovoAcidente(acidente, uriBuilder);
        acidenteService.cadastrarNovoAcidente(acidente2, uriBuilder2);
    }
}