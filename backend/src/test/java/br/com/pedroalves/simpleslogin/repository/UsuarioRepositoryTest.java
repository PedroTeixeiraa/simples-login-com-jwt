package br.com.pedroalves.simpleslogin.repository;

import br.com.pedroalves.simpleslogin.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static br.com.pedroalves.simpleslogin.utils.usuario.UsuarioUtils.criarUsuario;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void encontrarUsuarioComEmail() {
        // arrange
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);
        entityManager.flush();

        // act
        Optional<Usuario> resultado = usuarioRepository.findByEmail(usuario.getEmail());

        // assert
        assertEquals(usuario.getEmail(), resultado.get().getEmail());
    }

    @Test
    public void encontrarUsuarioComID() {
        // arrange
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);
        entityManager.flush();

        // act
        Optional<Usuario> resultado = usuarioRepository.findById(usuario.getId());

        // assert
        assertEquals(usuario.getId(), resultado.get().getId());
    }
}
