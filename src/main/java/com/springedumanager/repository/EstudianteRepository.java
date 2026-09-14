package com.springedumanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springedumanager.model.Estudiante;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}