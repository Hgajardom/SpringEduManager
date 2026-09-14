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

import com.springedumanager.model.Estudiante;
import com.springedumanager.repository.EstudianteRepository;



@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {



    private final EstudianteRepository repository;


    public EstudianteRestController(EstudianteRepository repository) {
        this.repository = repository;
    }



    // Listar estudiantes
    @GetMapping
    public List<Estudiante> listar(){

        return repository.findAll();

    }



    // Crear estudiante
    @PostMapping
    public Estudiante guardar(
            @RequestBody Estudiante estudiante){

        return repository.save(estudiante);

    }



    // Actualizar estudiante
    @PutMapping("/{id}")
    public Estudiante actualizar(
            @PathVariable Long id,
            @RequestBody Estudiante estudiante){


        estudiante.setId(id);

        return repository.save(estudiante);

    }



    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id){

        repository.deleteById(id);

    }


}