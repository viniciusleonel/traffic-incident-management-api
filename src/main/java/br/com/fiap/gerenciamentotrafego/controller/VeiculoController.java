//package br.com.fiap.gerenciamentotrafego.controller;
//
//import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
//import br.com.fiap.gerenciamentotrafego.dto.VeiculoCadastroDTO;
//import br.com.fiap.gerenciamentotrafego.dto.VeiculoExibicaoDTO;
//import br.com.fiap.gerenciamentotrafego.service.VeiculoService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@RestController
//@RequestMapping("veiculos")
//@CrossOrigin(origins = {"*"})
//public class VeiculoController {
//
//    @Autowired
//    private VeiculoService veiculoService;
//
//    @PostMapping
//    public ResponseEntity<?> cadastrarVeiculo(@RequestBody @Valid VeiculoCadastroDTO veiculo, UriComponentsBuilder uriBuilder) {
//
//        return veiculoService.cadastrarNovoVeiculo(veiculo, uriBuilder);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<VeiculoExibicaoDTO>> listarVeiculos(@PageableDefault(size = 10, sort = {"placa"}) Pageable paginacao) {
//        Page<VeiculoExibicaoDTO> page = veiculoService.listarVeiculos(paginacao);
//        return ResponseEntity.ok(page);
//    }
//}
