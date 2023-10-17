package com.example.frontendcliconsi.service;

import com.example.frontendcliconsi.entity.Cliente;
import com.example.frontendcliconsi.entity.Consignatario;

import java.util.List;

public interface ConsignatarioService {
    List<Consignatario> getConsignatario();
    String saveConsignatario(Consignatario cliente);
    String updateConsignatario(Consignatario cliente);
}
