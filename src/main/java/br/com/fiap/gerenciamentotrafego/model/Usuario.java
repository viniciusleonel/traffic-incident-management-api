package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Table(name = "tbl_usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String senha;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioRole role;

    public Usuario (UsuarioCadastroDTO dados, PasswordEncoder passwordEncoder) {
        this.email = dados.email();
        criptografarSenha(dados.senha(), passwordEncoder);
        this.role = dados.role();
    }

    private void criptografarSenha(String senha, PasswordEncoder passwordEncoder) {
        this.senha = passwordEncoder.encode(senha);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.role == UsuarioRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }

    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}