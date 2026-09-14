package com.springedumanager.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springedumanager.model.Estudiante;
import com.springedumanager.repository.EstudianteRepository;


@Service
public class EstudianteService {


    private final EstudianteRepository repository;


    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }



    public List<Estudiante> listarEstudiantes(){

        return repository.findAll();

    }



    public Estudiante guardarEstudiante(Estudiante estudiante){

        return repository.save(estudiante);

    }



    public void eliminarEstudiante(Long id){

        repository.deleteById(id);

    }

}