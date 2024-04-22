package com.api.templatemethod.controller;

import com.api.templatemethod.entidade.Carro;
import com.api.templatemethod.service.CarroService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController extends KlabCrudController<Carro, CarroService>{

    public CarroController() {
        super(CarroService.getInstancia());
    }
}
