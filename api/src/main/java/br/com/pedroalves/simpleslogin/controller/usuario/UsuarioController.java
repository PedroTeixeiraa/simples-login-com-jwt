package br.com.pedroalves.simpleslogin.controller.usuario;


import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.controller.usuario.response.UsuarioResponse;
import br.com.pedroalves.simpleslogin.security.UserPrincipal;
import br.com.pedroalves.simpleslogin.service.usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cadastrarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest){
        usuarioServiceImpl.cadastrar(usuarioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RolesAllowed("USUARIO")
    public UsuarioResponse buscarDadosDoUsuarioLogado(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return usuarioServiceImpl.buscarDadosDoUsuarioLogado(userPrincipal.getId());
    }
}
