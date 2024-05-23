package br.com.fiap.gerenciamentotrafego.repository;

import br.com.fiap.gerenciamentotrafego.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String email);

    boolean existsByEmail(String email);
}
