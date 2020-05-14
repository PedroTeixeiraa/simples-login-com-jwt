package br.com.pedroalves.simpleslogin.controller.autenticacao;

import br.com.pedroalves.simpleslogin.controller.autenticacao.request.LoginRequest;
import br.com.pedroalves.simpleslogin.controller.autenticacao.response.LoginResponse;
import br.com.pedroalves.simpleslogin.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/login")

public class AutenticacaoController {

    @Autowired
    private AuthenticationService service;

    @PostMapping
    public LoginResponse login(@RequestBody @Valid LoginRequest request){

        final String token = service.authenticate(request.getEmail(), request.getPassword());

        return new LoginResponse(token);
    }

}
