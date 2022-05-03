/**
 * 
 */
package com.ColegioSanLuis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ColegioSanLuis.Modelo.asignatura;



/**
 * @author CARLOS
 *
 */
public interface asignaturaInterfaceRepo extends JpaRepository<asignatura, Integer>{

	 public asignatura findByName(String nomAsignatura);
}
