package com.api.templatemethod.controller;

import com.api.templatemethod.response.Response;
import com.api.templatemethod.service.KlabService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
public abstract class KlabCrudController<Entity, Service extends KlabService<Entity>> {

    private Service service;
    public KlabCrudController(Service service) {
        this.service = service;
    }

    @PostMapping(path = "/inserir")
    public final ResponseEntity<Response<Object>> inserir(@RequestBody Entity entity) {
        Response<Object> response = new Response<>();
        try {
            if (validarInserir(entity)) {
                completarInserir(entity);
                Object objInserir = getService().inserir(entity);
                completarPosInserir(objInserir);
                response.setData(objInserir);
                return ResponseEntity.ok(response);
            } else {
                throw new RuntimeException("Falha na validação da inserção.");
            }
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    protected boolean validarInserir(Entity entity) {
        return true;
    }
    protected void completarInserir(Entity entity) { }
    protected void completarPosInserir(Object entity) { }
}
