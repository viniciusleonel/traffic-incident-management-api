package br.com.fiap.gerenciamentotrafego;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.model.Usuario;
import br.com.fiap.gerenciamentotrafego.model.UsuarioRole;
import br.com.fiap.gerenciamentotrafego.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GerenciamentoTrafegoApplicationTests {

//	@Autowired
//	private TestEntityManager em;
//
//	@Autowired
//	private UsuarioService usuarioService; // Substitua MeuServico pelo nome do seu serviço
//
//	@Test
//	public void testeMetodoDoServico() {
//		// Executar o método que você quer testar
//		Usuario usuario = new Usuario(dadosUsuario);
//
//		String resultado = usuarioService.cadastrarNovoUsuario(dadosUsuario);
//
//		// Verificar se o resultado está correto
//		assertEquals("resultado_esperado", resultado); // Substitua resultado_esperado pelo resultado que você espera
//	}
//
//	private Usuario cadastrarUsuario (String email, String senha, UsuarioRole role) {
//		var usuario = new Usuario(dadosUsuario(email, senha, role));
//		em.persist(usuario);
//		return usuario;
//	}
//
//	private UsuarioCadastroDTO dadosUsuario (String email, String senha, UsuarioRole role){
//		return new UsuarioCadastroDTO(
//				"example@admin.com",
//				"senha123",
//				UsuarioRole.ADMIN
//		);
//	}


}
