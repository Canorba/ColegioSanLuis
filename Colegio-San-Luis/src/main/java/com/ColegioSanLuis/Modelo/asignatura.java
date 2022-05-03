/**
 * 
 */
package com.ColegioSanLuis.Modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "asignatura")
public class asignatura  {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
    @JoinColumn(name = "COURSE_ID") })
    private int codAsignatura;
    @NotEmpty(message = "")
    private String nomAsignatura;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<asignatura> courses;
    private Set<estudiante> students;
    private Set<profesor> teacher;
    
    
   
    /**
	 * @return the codAsignatura
	 */
	public int getCodAsignatura() {
		return codAsignatura;
	}

	/**
	 * @param codAsignatura the codAsignatura to set
	 */
	public void setCodAsignatura(int codAsignatura) {
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
	 * @return the teacher
	 */
	public Set<profesor> getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Set<profesor> teacher) {
		this.teacher = teacher;
	}
	
	/**
	 * @return the students
	 */
	public Set<estudiante> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<estudiante> students) {
		this.students = students;
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
		course.getStudents().addAll(students);
		
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

