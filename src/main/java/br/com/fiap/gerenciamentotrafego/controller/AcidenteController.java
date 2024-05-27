package br.com.fiap.gerenciamentotrafego.controller;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.service.AcidenteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("acidentes")
@CrossOrigin(origins = {"*"})
public class AcidenteController {


    @Autowired
    private AcidenteService acidenteService;

    @PostMapping("cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AcidenteCadastroDTO dados, UriComponentsBuilder uriBuilder) {

        return acidenteService.cadastrarNovoAcidente(dados, uriBuilder);
    }

    @GetMapping("listar")
    public ResponseEntity<Page<AcidenteExibicaoDTO>> listarAcidentes(@PageableDefault(size = 10, sort = {"idAcidente"}) Pageable paginacao) {
        Page<AcidenteExibicaoDTO> page = acidenteService.listarAcidentes(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid AcidenteCadastroDTO dados, @PathVariable Long id){

        return acidenteService.atualizarAcidente(dados, id);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity excluir(@PathVariable Long id){

        return acidenteService.excluirAcidente(id);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity buscar(@PathVariable Long id){

        return acidenteService.buscarAcidente(id);
    }
}
