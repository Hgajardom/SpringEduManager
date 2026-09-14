package com.springedumanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springedumanager.model.Estudiante;
import com.springedumanager.service.EstudianteService;



@Controller
public class EstudianteController {


    private final EstudianteService service;


    public EstudianteController(EstudianteService service) {
        this.service = service;
    }



    @GetMapping("/estudiantes")
    public String listar(Model model) {

        model.addAttribute(
                "estudiantes",
                service.listarEstudiantes()
        );

        return "estudiantes";
    }



    @PostMapping("/guardarEstudiante")
    public String guardar(Estudiante estudiante) {

        service.guardarEstudiante(estudiante);

        return "redirect:/estudiantes";
    }

}