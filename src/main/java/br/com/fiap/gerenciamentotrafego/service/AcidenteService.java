package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.dto.AcidenteCadastroDTO;
import br.com.fiap.gerenciamentotrafego.dto.AcidenteExibicaoDTO;
import br.com.fiap.gerenciamentotrafego.model.Acidente;
import br.com.fiap.gerenciamentotrafego.repository.AcidenteRepository;
import br.com.fiap.gerenciamentotrafego.repository.RuaRepository;
import br.com.fiap.gerenciamentotrafego.repository.VeiculoRepository;
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

import java.util.Optional;

@Service
public class AcidenteService {

    @Autowired
    private AcidenteRepository acidenteRepository;

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private RuaRepository ruaRepository;

    @Transactional
    public ResponseEntity<?> cadastrarNovoAcidente(AcidenteCadastroDTO dados, UriComponentsBuilder uriBuilder) {

        Acidente acidente = new Acidente(dados);
        acidenteRepository.save(acidente);
        veiculoService.saveAll(acidente.getVeiculos());
        ruaRepository.save(acidente.getRua());
        var uri = uriBuilder.path("/acidentes/{id}").buildAndExpand(acidente.getIdAcidente()).toUri();
        return ResponseEntity.created(uri).body(new AcidenteExibicaoDTO(acidente));
    }

    public Page<AcidenteExibicaoDTO> listarAcidentes(Pageable paginacao) {
        return acidenteRepository.findAll(paginacao).map(AcidenteExibicaoDTO::new);
    }

    @Transactional
    public ResponseEntity atualizarAcidente(@RequestBody @Valid AcidenteCadastroDTO dados, @PathVariable String id){
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(id);
        if (acidenteOptional.isPresent()) {
            Acidente acidente = acidenteOptional.get();
            acidente.atualizarInformacoes(dados);
            acidenteRepository.save(acidente);
            return ResponseEntity.ok(new AcidenteExibicaoDTO(acidente));
        } else {
            return ResponseEntity.badRequest().body("Acidente não encontrado!");
        }
    }

    @Transactional
    public ResponseEntity excluirAcidente(@PathVariable String id){
        Optional<Acidente> acidenteOptional = acidenteRepository.findById(id);
        if (acidenteOptional.isPresent()) {
            acidenteRepository.delete(acidenteOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body("Acidente não encontrado!");
        }

    }

    public ResponseEntity buscarAcidente(@PathVariable String id){

        Optional<Acidente> acidenteOptional = acidenteRepository.findById(id);
        if (acidenteOptional.isPresent()) {
            return ResponseEntity.ok(new AcidenteExibicaoDTO(acidenteOptional.get()));
        } else {
            throw new RuntimeException("Acidente não encontrado!");
        }

    }

}