/**
 * 
 */
package com.ColegioSanLuis.Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesor")
public class profesor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idProfesor;
	@NotEmpty(message = "")
	private String nombre;
	@NotEmpty(message = "")
	private String apellido;
	@Column(nullable = true, name = "email")
	private String email;
	private Set<asignatura> courses;
	
	

	/**
	 * @return the idProfesor
	 */
	public int getIdProfesor() {
		return idProfesor;
	}

	/**
	 * @param idProfesor the idProfesor to set
	 */
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
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
	 * 
	 */
	public profesor() {
		super();
	}
	
	public Set<asignatura> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<asignatura> courses) {
		this.courses = courses;
	}

	

	public void addCourse(asignatura course) {
		this.courses.add(course);
		course.getTeacher().add(this);
	}

	public void removeCourse(asignatura course) {
		this.getCourses().remove(course);
		course.getTeacher().remove(this);
	}

	public void removeCourses() {
		for (asignatura course : new HashSet<>(courses)) {
			removeCourse(course);
		}
	}
}
