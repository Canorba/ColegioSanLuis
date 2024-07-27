package com.Prueba.Colegio.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba.Colegio.Modelo.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
