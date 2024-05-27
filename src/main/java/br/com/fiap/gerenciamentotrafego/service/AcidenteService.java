package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.repository.AcidenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Transactional
    public ResponseEntity atualizarAcidente(@RequestBody @Valid AcidenteCadastroDTO dados, @PathVariable Long id){
        Acidente acidente = acidenteRepository.getReferenceById(id);
        boolean acidenteExiste = acidenteRepository.existsById(acidente.getIdAcidente());

        if (acidenteExiste) {
            acidente.atualizarInformacoes(dados);
            return ResponseEntity.ok(new AcidenteExibicaoDTO(acidente));
        } else {
            return ResponseEntity.badRequest().body("Acidente não encontrado!");
        }
    }

    @Transactional
    public ResponseEntity excluirAcidente(@PathVariable Long id){
        Acidente acidente = acidenteRepository.getReferenceById(id);
        boolean acidenteExiste = acidenteRepository.existsById(acidente.getIdAcidente());
        if (acidenteExiste) {
            acidenteRepository.delete(acidente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body("Acidente não encontrado!");
        }

    }

}


