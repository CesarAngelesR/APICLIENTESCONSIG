package com.example.frontendcliconsi.service;

import com.example.frontendcliconsi.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getCliente();
    String saveCliente(Cliente cliente);
    String updateCliente(Cliente cliente);
}
