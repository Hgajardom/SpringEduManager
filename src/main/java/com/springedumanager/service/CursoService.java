package com.springedumanager.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springedumanager.model.Curso;
import com.springedumanager.repository.CursoRepository;


@Service
public class CursoService {


    private final CursoRepository repository;


    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }



    public List<Curso> listarCursos(){

        return repository.findAll();

    }



    public Curso guardarCurso(Curso curso){

        return repository.save(curso);

    }



    public void eliminarCurso(Long id){

        repository.deleteById(id);

    }

}