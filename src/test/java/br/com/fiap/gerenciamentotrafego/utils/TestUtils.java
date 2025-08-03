package br.com.fiap.gerenciamentotrafego.utils;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestUtils {
    public static void cadastrarUsuario(MockMvc mockMvc, ObjectMapper objectMapper, String email, String senha, UsuarioRole role) throws Exception {
        UsuarioCadastroDTO usuario = new UsuarioCadastroDTO(email, senha, role);
        mockMvc.perform(post("/usuarios/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated());
    }
}

