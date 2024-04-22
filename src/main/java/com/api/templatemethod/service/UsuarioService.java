package com.api.templatemethod.service;

import com.api.templatemethod.entidade.Usuario;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends KlabService<Usuario> {
    private static UsuarioService instancia;

    public static UsuarioService getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioService();
        }
        return instancia;
    }

    @Override
    public Usuario inserir(Session session, Usuario usuario) {
        return usuario;
    }
}
