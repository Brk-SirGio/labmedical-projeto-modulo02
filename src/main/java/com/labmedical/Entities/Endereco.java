package com.labmedical.Entities;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Embeddable
@Data
public class Endereco {
    private String cep;
    private String cidade;
    private String estado;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String pontoDeReferencia;
}
