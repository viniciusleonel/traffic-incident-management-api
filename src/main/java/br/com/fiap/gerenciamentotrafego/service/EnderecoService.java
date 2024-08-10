package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.model.Endereco;
import br.com.fiap.gerenciamentotrafego.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public void salvarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    @Transactional
    public void excluirEnderecoByAcidenteId(String acidenteId) {
        enderecoRepository.deleteByAcidenteId(acidenteId);
    }

    public void deleteAll() {
        enderecoRepository.deleteAll();
    }
}
