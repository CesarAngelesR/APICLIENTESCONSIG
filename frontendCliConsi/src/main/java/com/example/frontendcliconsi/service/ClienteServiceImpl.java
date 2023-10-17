package com.example.frontendcliconsi.service;

import com.example.frontendcliconsi.entity.Cliente;
import com.example.frontendcliconsi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository repository;

    @Override
    public List<Cliente> getCliente() {
        return repository.getAll();
    }

    @Override
    public String saveCliente(Cliente cliente) {
        String resp = repository.saveCliente(String.valueOf(cliente.isClienteactivo()), cliente.getClientenombre()).toString();
        System.out.printf(resp);
        if (resp.equals("se almaceno correctamente"))
            return "OK";
        else
            return "No se almaceno";
    }

    @Override
    public String updateCliente(Cliente cliente) {
        return null;
    }
}
