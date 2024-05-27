package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.model.Usuario;
import br.com.fiap.gerenciamentotrafego.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean usuarioExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Transactional
    public ResponseEntity<?> cadastrarNovoUsuario(UsuarioCadastroDTO dados, UriComponentsBuilder uriBuilder) {
        Usuario usuario = new Usuario(dados, passwordEncoder);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioExibicaoDTO(usuario));
    }

    public Page<UsuarioExibicaoDTO> listarUsuarios(Pageable paginacao) {
        return usuarioRepository.findAll(paginacao).map(UsuarioExibicaoDTO::new);
    }

}
