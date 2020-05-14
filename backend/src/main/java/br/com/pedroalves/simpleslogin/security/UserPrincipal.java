package br.com.pedroalves.simpleslogin.security;

import br.com.pedroalves.simpleslogin.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
public class UserPrincipal implements UserDetails {

    private Long id;

    private String nomeCompleto;

    private String email;

    private LocalDate dataNascimento;

    @JsonIgnore
    private String senha;

    private String cpf;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String nomeCompleto,
                         String email, LocalDate dataNascimento,
                         String senha, String cpf, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.cpf = cpf;
        this.authorities = authorities;
    }

    public UserPrincipal() {

    }

    public static UserPrincipal create(Usuario usuario) {

        List<GrantedAuthority> authorities = Arrays.asList(
            new SimpleGrantedAuthority(usuario.getPerfil().getRole())
        );

        return new UserPrincipal(
            usuario.getId(),
            usuario.getNomeCompleto(),
            usuario.getEmail(),
            usuario.getDataNascimento(),
            usuario.getSenha(),
            usuario.getCpf(),
            authorities
        );
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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