package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.model.Rua;
import br.com.fiap.gerenciamentotrafego.model.Usuario;
import br.com.fiap.gerenciamentotrafego.model.Veiculo;
import br.com.fiap.gerenciamentotrafego.repository.AcidenteRepository;
//import br.com.fiap.gerenciamentotrafego.repository.RuaRepository;
import br.com.fiap.gerenciamentotrafego.repository.UsuarioRepository;
//import br.com.fiap.gerenciamentotrafego.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

//    @Autowired
//    private VeiculoRepository veiculoRepository;

//    @Autowired
//    private RuaRepository ruaRepository;

    @Transactional
    public ResponseEntity<?> cadastrarNovoAcidente(AcidenteCadastroDTO dados, UriComponentsBuilder uriBuilder) {

//        Veiculo veiculo = new Veiculo(dados.veiculo());
//        veiculoRepository.save(veiculo);
//        Rua rua = new Rua(dados.rua());
//        ruaRepository.save(rua);
        Acidente acidente = new Acidente(dados);
        acidenteRepository.save(acidente);
        var uri = uriBuilder.path("/acidentes/{id}").buildAndExpand(acidente.getIdAcidente()).toUri();
        return ResponseEntity.created(uri).body(new AcidenteExibicaoDTO(acidente));
    }
}


