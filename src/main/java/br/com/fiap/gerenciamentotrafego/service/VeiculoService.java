//package br.com.fiap.gerenciamentotrafego.service;
//
//import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
//import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
//import br.com.fiap.gerenciamentotrafego.dto.VeiculoCadastroDTO;
//import br.com.fiap.gerenciamentotrafego.dto.VeiculoExibicaoDTO;
//import br.com.fiap.gerenciamentotrafego.model.Usuario;
//import br.com.fiap.gerenciamentotrafego.model.Veiculo;
//import br.com.fiap.gerenciamentotrafego.repository.VeiculoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//public class VeiculoService {
//
//    @Autowired
//    VeiculoRepository veiculoRepository;
//
//    @Transactional
//    public ResponseEntity<?> cadastrarNovoVeiculo(VeiculoCadastroDTO dados, UriComponentsBuilder uriBuilder) {
//        Veiculo veiculo = new Veiculo(dados);
//        veiculoRepository.save(veiculo);
//        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(veiculo.getIdVeiculo()).toUri();
//        return ResponseEntity.created(uri).body(new VeiculoExibicaoDTO(veiculo));
//    }
//
//    public Page<VeiculoExibicaoDTO> listarVeiculos(Pageable paginacao) {
//        return veiculoRepository.findAll(paginacao).map(VeiculoExibicaoDTO::new);
//    }
//
//}
