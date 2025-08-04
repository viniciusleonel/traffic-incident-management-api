package br.com.fiap.gerenciamentotrafego;

import br.com.fiap.gerenciamentotrafego.controller.AutenticacaoControllerTest;
import br.com.fiap.gerenciamentotrafego.controller.UsuarioControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class GerenciamentoTrafegoApplicationTests {

    @Autowired
    private org.springframework.core.env.Environment environment;

    @Test
    void testaProfileAtivo() {
        System.out.println("Profile ativo: " + System.getProperty("spring.profiles.active"));

        System.out.println("Profiles ativos: " + Arrays.toString(environment.getActiveProfiles()));
    }

}