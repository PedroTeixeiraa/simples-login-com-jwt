package br.com.pedroalves.simpleslogin.service.usuario;


import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.controller.usuario.response.UsuarioResponse;
import br.com.pedroalves.simpleslogin.mapper.UsuarioMapper;
import br.com.pedroalves.simpleslogin.model.Usuario;
import br.com.pedroalves.simpleslogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void cadastrar(UsuarioRequest usuarioRequest) {

        Usuario usuario = UsuarioMapper.transformarUsuario(usuarioRequest);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioResponse buscarDadosDoUsuarioLogado(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(!usuario.isPresent()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return UsuarioMapper.transformarUsuarioResponse(usuario.get());
    }
}
