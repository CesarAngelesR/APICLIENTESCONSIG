package com.example.frontendcliconsi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Consignatario {
    @Id
    private Integer consignatarioid;
    private Integer clienteid;
    private boolean consignatarioactivo;
    private String consignatarionombre;
    private String consignatariofechacreacion;
    private String consignatariofechamodificacion;
}
