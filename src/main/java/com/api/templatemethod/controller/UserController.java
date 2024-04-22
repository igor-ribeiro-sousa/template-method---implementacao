package com.api.templatemethod.controller;

import com.api.templatemethod.entidade.Usuario;
import com.api.templatemethod.service.UsuarioService;
import com.api.templatemethod.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UserController extends KlabCrudController<Usuario, UsuarioService>{

    public UserController(){ super(UsuarioService.getInstancia()); }
    @Override
    protected void completarInserir(Usuario usuario) {
        usuario.setNome(usuario.getNome().toUpperCase().trim());
        usuario.setEmail(usuario.getEmail().toUpperCase().trim());
    }
    @Override
    protected boolean validarInserir(Usuario usuario) {
        if(Objects.isNull(usuario.getNome()) || usuario.getNome().isEmpty()){
            throw new RuntimeException("O nome do usuário é obrigatório.");
        }
        if(Objects.isNull(usuario.getEmail()) || usuario.getEmail().isEmpty()){
            throw new RuntimeException("O e-mail do usuário é obrigatório.");
        }
        if(!Util.validarEmail(usuario.getEmail().trim())){
            throw new RuntimeException("E-mail inválido.");
        }
        return true;
    }
}
