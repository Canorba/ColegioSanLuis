/**
 * 
 */
package com.ColegioSanLuis.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ColegioSanLuis.Modelo.profesor;


/**
 * @author CARLOS
 *
 */
public interface profesorInterfaceRepo  extends JpaRepository<profesor, Integer>{

}
