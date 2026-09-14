package com.springedumanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springedumanager.model.Curso;
import com.springedumanager.service.CursoService;



@Controller
public class CursoController {


    private final CursoService service;


    public CursoController(CursoService service) {
        this.service = service;
    }



    @GetMapping("/cursos")
    public String listar(Model model) {

        model.addAttribute(
                "cursos",
                service.listarCursos()
        );

        return "cursos";
    }



    @PostMapping("/guardarCurso")
    public String guardar(Curso curso) {

        service.guardarCurso(curso);

        return "redirect:/cursos";
    }

}