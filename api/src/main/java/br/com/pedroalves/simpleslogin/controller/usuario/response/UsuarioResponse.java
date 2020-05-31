package br.com.pedroalves.simpleslogin.controller.usuario.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponse {

    private String nomeCompleto;

    private String email;

    private LocalDate dataNascimento;

    private String cpf;
}
