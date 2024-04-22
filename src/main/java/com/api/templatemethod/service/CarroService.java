package com.api.templatemethod.service;

import com.api.templatemethod.entidade.Carro;
import com.api.templatemethod.entidade.Usuario;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class CarroService extends KlabService<Carro> {
    private static CarroService instancia;
    public static CarroService getInstancia() {
        if (instancia == null) {
            instancia = new CarroService();
        }
        return instancia;
    }

}
