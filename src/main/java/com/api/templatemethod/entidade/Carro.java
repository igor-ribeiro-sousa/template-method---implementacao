package com.api.templatemethod.entidade;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro {
    @Id
    private Integer codigo;
    private String nome;
    private String marca;
}
