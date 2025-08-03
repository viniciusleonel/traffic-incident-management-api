package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;
import br.com.fiap.gerenciamentotrafego.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    private static final Logger log = LoggerFactory.getLogger(UsuarioControllerTest.class);

    @BeforeEach
    public void setUp() {
        log.info("Limpando banco de dados antes do teste");
        mongoTemplate.getDb().drop();
    }

    @Test
    void deveCadastrarNovoUsuario() throws Exception {
        log.info("Iniciando teste: deveCadastrarNovoUsuario");
        UsuarioCadastroDTO usuarioTest = new UsuarioCadastroDTO(
                "teste@exemplo.com",
                "1234",
                UsuarioRole.ADMIN
        );

        String payload = objectMapper.writeValueAsString(usuarioTest);
        log.debug("Payload enviado (cadastro válido): {}", payload);

        mockMvc.perform(post("/usuarios/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioTest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.email").value("teste@exemplo.com"))
                .andExpect(jsonPath("$.role").value("ADMIN"));

        log.info("Teste concluído com sucesso: deveCadastrarNovoUsuario");
    }

    @Test
    void deveRetornarErroQuandoEmailForInvalido() throws Exception {
        log.info("Iniciando teste: deveRetornarErroQuandoEmailForInvalido");
        UsuarioCadastroDTO usuarioTest = new UsuarioCadastroDTO(
                "email-invalido",
                "1234",
                UsuarioRole.ADMIN
        );

        String payload = objectMapper.writeValueAsString(usuarioTest);
        log.debug("Payload enviado (email inválido): {}", payload);

        mockMvc.perform(post("/usuarios/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioTest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.email").value("Insira um e-mail válido!"));

        log.info("Teste concluído com sucesso: deveRetornarErroQuandoEmailForInvalido");
    }

    @Test
    void deveRetornarErroQuandoEmailJaExistir() throws Exception {
        log.info("Iniciando teste: deveRetornarErroQuandoEmailJaExistir");
        UsuarioCadastroDTO usuarioTest = new UsuarioCadastroDTO(
                "duplicado@exemplo.com",
                "1234",
                UsuarioRole.ADMIN
        );

        String payload = objectMapper.writeValueAsString(usuarioTest);
        log.debug("Payload enviado (usuário duplicado): {}", payload);

        mockMvc.perform(post("/usuarios/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioTest)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/usuarios/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioTest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Usuário já cadastrado!"));

        log.info("Teste concluído com sucesso: deveRetornarErroQuandoEmailJaExistir");
    }
}
