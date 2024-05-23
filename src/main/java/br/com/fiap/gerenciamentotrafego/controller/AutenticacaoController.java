package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.AutenticacaoDTO;
import br.com.fiap.gerenciamentotrafego.dto.TokenJWTDTO;
import br.com.fiap.gerenciamentotrafego.model.Usuario;
import br.com.fiap.gerenciamentotrafego.service.AutenticacaoService;
import br.com.fiap.gerenciamentotrafego.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"*"})
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados){

        // Verificar se o usuário existe no banco de dados
        UserDetails usuario = autenticacaoService.loadUserByUsername(dados.email());
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }

        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            dados.email(), dados.senha()
                    );
            Authentication authentication =
                    manager.authenticate(
                            authenticationToken
                    );
            var tokenJWT =
                    tokenService.gerarToken(
                            (Usuario) authentication.getPrincipal()
                    );

            return ResponseEntity.ok(new TokenJWTDTO(tokenJWT));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }

    }
}
