package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Ferido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeridoRepository extends MongoRepository<Ferido, String> {

    void deleteByAcidenteId(String acidenteId);

    List<Ferido> findByAcidenteId(String acidenteId);
}