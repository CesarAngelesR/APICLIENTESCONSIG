package com.example.frontendcliconsi.service;

import com.example.frontendcliconsi.entity.Cliente;
import com.example.frontendcliconsi.entity.Consignatario;
import com.example.frontendcliconsi.repository.ClienteRepository;
import com.example.frontendcliconsi.repository.ConsignatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignatarioServiceImpl implements ConsignatarioService {
    @Autowired
    ConsignatarioRepository repository;

    @Override
    public List<Consignatario> getConsignatario() {
        return repository.getAll();
    }

    @Override
    public String saveConsignatario(Consignatario consignatario) {
        String resp = repository.saveConsignatario(consignatario.getConsignatarioid(),consignatario.getClienteid(),
                String.valueOf(consignatario.isConsignatarioactivo()),
                consignatario.getConsignatarionombre()).toString();
        if (resp.contains("se almaceno correctamente"))
            return "OK";
        else
            return "No se almaceno";
    }

    @Override
    public String updateConsignatario(Consignatario cliente) {
        return null;
    }
}
