package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioCadastroDTO dados, UriComponentsBuilder uriBuilder) {

        if (usuarioService.usuarioExiste(dados.email())) {
            return ResponseEntity.badRequest().body("Usuário já cadastrado!");
        }

        return usuarioService.cadastrarNovoUsuario(dados, uriBuilder);
    }

    @SecurityRequirement(name = "bearer-key")
    @GetMapping
    public ResponseEntity<Page<UsuarioExibicaoDTO>> listarUsuarios(@PageableDefault(size = 10, sort = {"email"}) Pageable paginacao) {
        Page<UsuarioExibicaoDTO> page = usuarioService.listarUsuarios(paginacao);
        return ResponseEntity.ok(page);
    }
}