package br.com.pedroalves.simpleslogin.utils.usuario;

import br.com.pedroalves.simpleslogin.controller.usuario.request.UsuarioRequest;
import br.com.pedroalves.simpleslogin.model.Usuario;

import java.time.LocalDate;

public class UsuarioUtils {

    public static Usuario criarUsuario() {
        return Usuario.builder()
                .nomeCompleto("usuario teste")
                .email("usuario@email.com")
                .dataNascimento(LocalDate.now())
                .cpf("78533618077")
                .senha("senha123")
                .build();
    }

    public static UsuarioRequest criarUsuarioRequest() {
        return UsuarioRequest.builder()
                .nomeCompleto("usuario teste")
                .email("usuario@email.com")
                .dataNascimento(LocalDate.now())
                .cpf("78533618077")
                .senha("senha123")
                .build();
    }
}
