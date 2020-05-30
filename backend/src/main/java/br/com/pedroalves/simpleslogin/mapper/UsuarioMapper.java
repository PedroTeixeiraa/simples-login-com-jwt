package br.com.pedroalves.simpleslogin.mapper;

import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.controller.usuario.response.UsuarioResponse;
import br.com.pedroalves.simpleslogin.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuario transformarUsuario(UsuarioRequest usuarioRequest){

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(usuarioRequest.getNomeCompleto());
        usuario.setEmail( usuarioRequest.getEmail());
        usuario.setDataNascimento(usuarioRequest.getDataNascimento());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setCpf(usuarioRequest.getCpf());

        return usuario;
    }

    public static UsuarioResponse transformarUsuarioResponse(Usuario usuario){

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNomeCompleto(usuario.getNomeCompleto());
        usuarioResponse.setEmail( usuario.getEmail());
        usuarioResponse.setDataNascimento(usuario.getDataNascimento());
        usuarioResponse.setCpf(usuario.getCpf());

        return usuarioResponse;
    }


}
