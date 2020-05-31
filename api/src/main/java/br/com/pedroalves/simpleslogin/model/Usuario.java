package br.com.pedroalves.simpleslogin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotEmpty
    private String nomeCompleto;

    @Size(max = 200)
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @JsonIgnore
    @Size(max = 512)
    private String senha;

    @JsonIgnore
    public Perfil getPerfil() {
        return Perfil.USUARIO;
    }

}
