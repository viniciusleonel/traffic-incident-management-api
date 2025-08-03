package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.AutenticacaoDTO;
import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;
import br.com.fiap.gerenciamentotrafego.repository.UsuarioRepository;
import br.com.fiap.gerenciamentotrafego.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() throws Exception {
        mongoTemplate.getDb().drop();
        TestUtils.cadastrarUsuario(
                mockMvc,
                objectMapper,
                "teste@exemplo.com",
                "1234",
                UsuarioRole.ADMIN);
    }

    @Test
    void deveAutenticarUsuario() throws Exception {
        AutenticacaoDTO usuarioTest = new AutenticacaoDTO(
                "teste@exemplo.com",
                "1234"
        );

        mockMvc.perform(post("/autenticacao/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioTest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }
}
