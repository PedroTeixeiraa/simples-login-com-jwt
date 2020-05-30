package br.com.pedroalves.simpleslogin.service.usuario;

import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.controller.usuario.response.UsuarioResponse;
import br.com.pedroalves.simpleslogin.mapper.UsuarioMapper;
import br.com.pedroalves.simpleslogin.model.Usuario;
import br.com.pedroalves.simpleslogin.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static br.com.pedroalves.simpleslogin.utils.usuario.UsuarioUtils.criarUsuario;
import static br.com.pedroalves.simpleslogin.utils.usuario.UsuarioUtils.criarUsuarioRequest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void deveCadastrarUsuarioComSucesso() {
        // arrange
        UsuarioRequest usuarioRequest = criarUsuarioRequest();

        Usuario usuario = UsuarioMapper.transformarUsuario(usuarioRequest);
        when(passwordEncoder.encode(usuario.getSenha())).thenReturn(usuario.getSenha());

        // act
        usuarioService.cadastrar(usuarioRequest);

        // assert
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void deveBuscarDadosDoUsuarioLogado() {
        // arrange
        Long idUsuarioLogado = 2L;
        Usuario usuario = criarUsuario();

        when(usuarioRepository.findById(idUsuarioLogado)).thenReturn(Optional.of(usuario));

        // act
        UsuarioResponse retorno = usuarioService.buscarDadosDoUsuarioLogado(idUsuarioLogado);

        // assert
        assertEquals(usuario.getEmail(), retorno.getEmail());
        assertEquals(usuario.getCpf(), retorno.getCpf());
        assertEquals(usuario.getDataNascimento(), retorno.getDataNascimento());
        assertEquals(usuario.getNomeCompleto(), retorno.getNomeCompleto());

    }
}
