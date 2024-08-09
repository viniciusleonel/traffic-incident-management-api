package br.com.fiap.gerenciamentotrafego.service;

import br.com.fiap.gerenciamentotrafego.model.Ferido;
import br.com.fiap.gerenciamentotrafego.repository.FeridoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeridoService {

    @Autowired
    private FeridoRepository feridoRepository;

    @Transactional
    public void salvarListaFeridos(List<Ferido> feridos, String acidenteId){
        feridoRepository.saveAll(feridos);
    }

    @Transactional
    public void deleteFeridoByAcidenteId(String acidenteId){
        feridoRepository.deleteByAcidenteId(acidenteId);
    }

    public List<Ferido> getFeridoByAcidenteId(String acidenteId){
        return feridoRepository.findByAcidenteId(acidenteId);
    }

    public void deleteAll() {
        feridoRepository.deleteAll();
    }
}
