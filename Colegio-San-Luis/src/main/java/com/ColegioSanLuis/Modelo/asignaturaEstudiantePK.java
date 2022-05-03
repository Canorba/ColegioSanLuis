/**
 * 
 */
package com.ColegioSanLuis.Modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author CARLOS
 *
 */
@Embeddable
public class asignaturaEstudiantePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "numIdentificacion")
	Long numIdentificacion;

	@Column(name = "codAsignatura")
	Long codAsignatura;

	/**
	 * 
	 */
	public asignaturaEstudiantePK() {
		super();
	}

	/**
	 * @return the numIdentificacion
	 */
	public Long getNumIdentificacion() {
		return numIdentificacion;
	}

	/**
	 * @param numIdentificacion the numIdentificacion to set
	 */
	public void setNumIdentificacion(Long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	/**
	 * @return the codAsignatura
	 */
	public Long getCodAsignatura() {
		return codAsignatura;
	}

	/**
	 * @param codAsignatura the codAsignatura to set
	 */
	public void setCodAsignatura(Long codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAsignatura, numIdentificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		asignaturaEstudiantePK other = (asignaturaEstudiantePK) obj;
		return Objects.equals(codAsignatura, other.codAsignatura)
				&& Objects.equals(numIdentificacion, other.numIdentificacion);
	}
	
	
}
