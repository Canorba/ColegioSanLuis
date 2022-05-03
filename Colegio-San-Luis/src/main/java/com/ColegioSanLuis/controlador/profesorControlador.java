/**
 * 
 */
package com.ColegioSanLuis.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ColegioSanLuis.dto.profesorDTO;
import com.ColegioSanLuis.servicio.profesorServicioInterface;



/**
 * @author CARLOS
 *
 */
@RestController
public class profesorControlador {

	@Autowired
	private profesorServicioInterface teacherService;

	@GetMapping("/students")
	public ResponseEntity<List<profesorDTO>> getAllStudents() {
		List<profesorDTO> students = teacherService.getAllprofesor();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<profesorDTO> getAllTeacher(@RequestBody profesorDTO teacherDto) {
		profesorDTO std = teacherService.addProfesor(teacherDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<profesorDTO> updateTeacher(@PathVariable(name = "id") Integer id,
			@RequestBody profesorDTO teacher) {
		profesorDTO std = teacherService.updateTeacher(id, teacher);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable(name = "id") Integer teachertId) {
		String message = teacherService.deleteProfesor(teachertId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}	
}
