package com.example.frontendcliconsi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.SQLSelect;

@Entity
@Data
public class Cliente {
    @Id
    private Integer clienteid;
    private boolean clienteactivo;
    private String clientenombre;
    private String clientefechacreacion;
    private String clientefechamodificacion;
}
