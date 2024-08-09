package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.model.Veiculo;
import br.com.fiap.gerenciamentotrafego.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public void salvarListaVeiculos(List<Veiculo> veiculos, String acidenteId) {
        veiculoRepository.saveAll(veiculos);
    }

    @Transactional
    public void deleteAllByAcidenteId(String acidenteId) {
        veiculoRepository.deleteByAcidenteId(acidenteId);
    }

    public List<Veiculo> getAllByAcidenteId(String acidenteId) {
        return veiculoRepository.findByAcidenteId(acidenteId);
    }

}