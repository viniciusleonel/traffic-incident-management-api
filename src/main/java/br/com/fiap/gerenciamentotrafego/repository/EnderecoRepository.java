package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {

    void deleteByAcidenteId(String idAcidente);
}
