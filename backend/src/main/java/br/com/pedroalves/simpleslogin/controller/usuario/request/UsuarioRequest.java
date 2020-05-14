package br.com.pedroalves.simpleslogin.controller.usuario.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UsuarioRequest {

    @Size(max = 100)
    @NotEmpty(message = "O nome precisa ser informado!!!")
    private String nomeCompleto;

    @Size(max = 200)
    @Email
    @NotEmpty(message = "O email precisa ser válido!!!")
    private String email;

    @Size(max = 512)
    @NotEmpty(message = "A senha precisa ser informada!!!")
    private String senha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotNull
    @CPF
    private String cpf;

}
