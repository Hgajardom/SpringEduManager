package com.springedumanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springedumanager.model.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {

}