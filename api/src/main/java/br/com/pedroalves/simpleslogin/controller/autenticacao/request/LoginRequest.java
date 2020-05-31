package br.com.pedroalves.simpleslogin.controller.autenticacao.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}
