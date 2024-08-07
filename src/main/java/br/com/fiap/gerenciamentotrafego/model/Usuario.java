package br.com.fiap.gerenciamentotrafego.model;

import br.com.fiap.gerenciamentotrafego.dto.UsuarioCadastroDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Collection;
import java.util.List;

@Document(collection = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario implements UserDetails {

    @Id
    private String idUsuario;

    @Field
    private String email;

    @Field
    private String senha;

    @Field
    private UsuarioRole role;

    public Usuario (UsuarioCadastroDTO dados, PasswordEncoder passwordEncoder) {
        this.email = dados.email();
        criptografarSenha(dados.senha(), passwordEncoder);
        this.role = dados.role();
    }

    public Usuario(UsuarioCadastroDTO dados) {
        this.email = dados.email();
        this.senha = dados.senha();
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