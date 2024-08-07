package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    UserDetails findByEmail(String email);

    boolean existsByEmail(String email);
}