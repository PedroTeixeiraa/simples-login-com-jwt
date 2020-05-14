package br.com.pedroalves.simpleslogin.service.usuario;

import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.controller.usuario.response.UsuarioResponse;

public interface UsuarioService {

    void cadastrar(UsuarioRequest usuarioRequest);

    UsuarioResponse buscarDadosDoUsuarioLogado(Long id);
}
