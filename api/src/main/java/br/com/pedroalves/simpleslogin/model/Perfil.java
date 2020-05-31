package br.com.pedroalves.simpleslogin.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Perfil {

    USUARIO("ROLE_USUARIO");

    private final String role;

}
