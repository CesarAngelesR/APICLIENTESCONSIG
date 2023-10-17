package com.example.frontendcliconsi.controller;

import com.example.frontendcliconsi.entity.Cliente;
import com.example.frontendcliconsi.entity.Consignatario;
import com.example.frontendcliconsi.service.ClienteService;
import com.example.frontendcliconsi.service.ConsignatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/crud")
public class CrudController {
    @Autowired
    ClienteService service;
    @Autowired
    ConsignatarioService serviceC;

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> getClientes() {
        return new ResponseEntity<>(service.getCliente(), HttpStatus.valueOf(200));
    }

    @PostMapping("/cliente")
    public ResponseEntity<Object> saveClientes(@RequestBody Cliente c) {
        String response = service.saveCliente(c);
        if (response.contains("OK"))
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping("/consignatario")
    public ResponseEntity<List<Consignatario>> getConsignatario() {
        return new ResponseEntity<>(serviceC.getConsignatario(), HttpStatus.valueOf(200));
    }

    @PostMapping("/consignatario")
    public ResponseEntity<Object> saveConsignatario(@RequestBody Consignatario c) {
        String response = serviceC.saveConsignatario(c);
        if (response.contains("OK"))
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);
    }
}
