/**
 * 
 */
package com.ColegioSanLuis.Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
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
@Table(name = "estudiante")
public class estudiante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
    @JoinColumn(name = "COURSE_ID") })
	
	private Set<asignatura> courses;
	private int idEstudiante;
	private String nombre;
	@NotEmpty(message = "")
	private String apellido;
	@Column(nullable = true, name = "email")
	private String email;

	/**
	 * 
	 */
	public estudiante() {
		super();
	}

	/**
	 * @return the numIdentificacion
	 */
	public int getIdEstudiante() {
		return idEstudiante;
	}

	/**
	 * @param numIdentificacion the numIdentificacion to set
	 */
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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
	 * @return the courses
	 */
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
		course.getStudents().add(this);
	}

	public void removeCourse(asignatura course) {
		this.getCourses().remove(course);
		course.getStudents().remove(this);
	}

	public void removeCourses() {
		for (asignatura course : new HashSet<>(courses)) {
			removeCourse(course);
		}
	}
}
