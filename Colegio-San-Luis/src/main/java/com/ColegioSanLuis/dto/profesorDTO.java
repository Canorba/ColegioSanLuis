/**
 * 
 */
package com.ColegioSanLuis.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CARLOS
 *
 */
@Getter
@Setter
public class profesorDTO {

	private Integer numIdentificacion;
    private String nombre;
    private String apellido;
    private String email;
    private Set<String> asignatura = new HashSet<>();
	/**
	 * 
	 */
	public profesorDTO() {
		super();
	}
	/**
	 * @return the numIdentificacion
	 */
	public Integer getNumIdentificacion() {
		return numIdentificacion;
	}
	/**
	 * @param numIdentificacion the numIdentificacion to set
	 */
	public void setNumIdentificacion(Integer numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the asignatura
	 */
	public Set<String> getAsignatura() {
		return asignatura;
	}
	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(Set<String> asignatura) {
		this.asignatura = asignatura;
	}
    
    
}
