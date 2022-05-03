/**
 * 
 */
package com.ColegioSanLuis.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author CARLOS
 *
 */
@Getter
@Setter
public class asignaturaDTO {

	private Integer codAsignatura;
    private String nomAsignatura;

	/**
	 * 
	 */
	public asignaturaDTO() {
		super();
	}
	/**
	 * @return the codAsignatura
	 */
	public Integer getCodAsignatura() {
		return codAsignatura;
	}
	/**
	 * @param codAsignatura the codAsignatura to set
	 */
	public void setCodAsignatura(Integer codAsignatura) {
		this.codAsignatura = codAsignatura;
	}
	/**
	 * @return the nomAsignatura
	 */
	public String getNomAsignatura() {
		return nomAsignatura;
	}
	/**
	 * @param nomAsignatura the nomAsignatura to set
	 */
	public void setNomAsignatura(String nomAsignatura) {
		this.nomAsignatura = nomAsignatura;
	}
	/**
	 * @return the apellido
	 */
	
    
}
