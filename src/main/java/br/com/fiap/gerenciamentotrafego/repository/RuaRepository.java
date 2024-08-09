package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Rua;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuaRepository extends MongoRepository<Rua, String> {

    void deleteByAcidenteId(String idAcidente);
}
