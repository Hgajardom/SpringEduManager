package com.springedumanager.rest;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springedumanager.model.Curso;
import com.springedumanager.repository.CursoRepository;



@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {


    private final CursoRepository repository;


    public CursoRestController(CursoRepository repository) {
        this.repository = repository;
    }



    // Obtener todos los cursos
    @GetMapping
    public List<Curso> listar(){

        return repository.findAll();

    }



    // Crear curso
    @PostMapping
    public Curso guardar(
            @RequestBody Curso curso){

        return repository.save(curso);

    }



    // Actualizar curso
    @PutMapping("/{id}")
    public Curso actualizar(
            @PathVariable Long id,
            @RequestBody Curso curso){


        curso.setId(id);

        return repository.save(curso);

    }



    // Eliminar curso
    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id){

        repository.deleteById(id);

    }


}