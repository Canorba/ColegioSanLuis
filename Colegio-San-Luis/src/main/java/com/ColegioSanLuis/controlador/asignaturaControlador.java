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

import com.ColegioSanLuis.dto.asignaturaDTO;
import com.ColegioSanLuis.servicio.asignaturaInterfaceService;



/**
 * @author CARLOS
 *
 */
@RestController
public class asignaturaControlador {

	@Autowired
	private asignaturaInterfaceService courseService;

	@GetMapping("/students")
	public ResponseEntity<List<asignaturaDTO>> getAllStudents() {
		List<asignaturaDTO> students = courseService.getAllAsignaturas();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/student")
	public ResponseEntity<asignaturaDTO> getAllStudents(@RequestBody asignaturaDTO coursetDto) {
		asignaturaDTO std = courseService.addAsignatura(coursetDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<asignaturaDTO> updateStudent(@PathVariable(name = "id") Integer id,
			@RequestBody asignaturaDTO course) {
		asignaturaDTO std = courseService.addAsignatura(course);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer coursetId) {
		String message = courseService.deleteAsignatura(coursetId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
