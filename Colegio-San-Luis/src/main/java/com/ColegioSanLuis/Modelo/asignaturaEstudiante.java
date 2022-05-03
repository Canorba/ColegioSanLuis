/**
 * 
 */
package com.ColegioSanLuis.Modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author CARLOS
 *
 */

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignatura_estudiante")
public class asignaturaEstudiante {

	 @EmbeddedId
	 asignaturaProfesorPk id;

	    @ManyToOne
	    @MapsId("numIdentificacion")
	    @JoinColumn(name = "numIdentificacion")
	    profesor estudiante;

	    @ManyToOne
	    @MapsId("codAsignatura")
	    @JoinColumn(name = "codAsignatura")
	    asignatura asignatura;

	    int rating;

		/**
		 * 
		 */
		public asignaturaEstudiante() {
			super();
		}

		/**
		 * @return the id
		 */
		public asignaturaProfesorPk getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(asignaturaProfesorPk id) {
			this.id = id;
		}

		/**
		 * @return the estudiante
		 */
		public profesor getEstudiante() {
			return estudiante;
		}

		/**
		 * @param estudiante the estudiante to set
		 */
		public void setEstudiante(profesor estudiante) {
			this.estudiante = estudiante;
		}

		/**
		 * @return the asignatura
		 */
		public asignatura getAsignatura() {
			return asignatura;
		}

		/**
		 * @param asignatura the asignatura to set
		 */
		public void setAsignatura(asignatura asignatura) {
			this.asignatura = asignatura;
		}

		/**
		 * @return the rating
		 */
		public int getRating() {
			return rating;
		}

		/**
		 * @param rating the rating to set
		 */
		public void setRating(int rating) {
			this.rating = rating;
		}

	    
}
