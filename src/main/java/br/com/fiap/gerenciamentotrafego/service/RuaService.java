package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.model.Rua;
import br.com.fiap.gerenciamentotrafego.repository.RuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RuaService {

    @Autowired
    private RuaRepository ruaRepository;

    @Transactional
    public void salvarRua(Rua rua) {
        ruaRepository.save(rua);
    }

    @Transactional
    public void excluirRuaByAcidenteId(String acidenteId) {
        ruaRepository.deleteByAcidenteId(acidenteId);
    }
}
