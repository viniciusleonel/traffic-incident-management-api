package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.repository.AcidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

    @Transactional
    public ResponseEntity<?> cadastrarNovoAcidente(AcidenteCadastroDTO dados, UriComponentsBuilder uriBuilder) {

        Acidente acidente = new Acidente(dados);
        acidenteRepository.save(acidente);
        var uri = uriBuilder.path("/acidentes/{id}").buildAndExpand(acidente.getIdAcidente()).toUri();
        return ResponseEntity.created(uri).body(new AcidenteExibicaoDTO(acidente));
    }

    public Page<AcidenteExibicaoDTO> listarAcidentes(Pageable paginacao) {
        return acidenteRepository.findAll(paginacao).map(AcidenteExibicaoDTO::new);
    }


}


