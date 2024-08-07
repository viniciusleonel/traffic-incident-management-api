package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Acidente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcidenteRepository extends MongoRepository<Acidente,String> {

    boolean existsById(String id);
}
