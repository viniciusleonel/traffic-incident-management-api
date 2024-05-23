package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.service.AcidenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("acidentes")
@CrossOrigin(origins = {"*"})
public class AcidenteController {

    @GetMapping
    public String get () {
        return "Acidentes";
    }

    @Autowired
    private AcidenteService acidenteService;

    @PostMapping()
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AcidenteCadastroDTO dados, UriComponentsBuilder uriBuilder) {

        return acidenteService.cadastrarNovoAcidente(dados, uriBuilder);
    }
}
