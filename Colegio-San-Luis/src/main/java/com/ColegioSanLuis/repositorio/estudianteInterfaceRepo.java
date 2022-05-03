/**
 * 
 */
package com.ColegioSanLuis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ColegioSanLuis.Modelo.estudiante;

/**
 * @author CARLOS
 *
 */
public interface estudianteInterfaceRepo extends JpaRepository<estudiante, Integer>{

}
