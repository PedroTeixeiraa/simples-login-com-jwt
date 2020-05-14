package br.com.pedroalves.simpleslogin.repository;

import br.com.pedroalves.simpleslogin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

    Optional<Usuario> findById(Long id);
}
