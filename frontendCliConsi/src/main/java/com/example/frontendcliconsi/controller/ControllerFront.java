package com.example.frontendcliconsi.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class ControllerFront {
    @GetMapping("cliente")
    public String getViewCliente(Model model){
        return "cliente";
    }
    @GetMapping("consignatario")
    public String getViewConsignatario(Model model){
        return "consignatario";
    }
}
