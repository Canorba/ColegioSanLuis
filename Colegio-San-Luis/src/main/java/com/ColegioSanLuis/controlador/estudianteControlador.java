/**
 * 
 */
package com.ColegioSanLuis.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ColegioSanLuis.dto.estudianteDTO;
import com.ColegioSanLuis.servicio.estudianteInterfaceservice;

/**
 * @author CARLOS
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class estudianteControlador {

	@Autowired
	private estudianteInterfaceservice studentService;

	@GetMapping("/estudiante")
	public ResponseEntity<List<estudianteDTO>> getAllStudents() {
		List<estudianteDTO> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/estudiante")
	public ResponseEntity<estudianteDTO> getAllStudents(@RequestBody estudianteDTO studentDto) {
		estudianteDTO std = studentService.addStudent(studentDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/estudiante/{id}")
	public ResponseEntity<estudianteDTO> updateStudent(@PathVariable(name = "id") Integer id,
			@RequestBody estudianteDTO student) {
		estudianteDTO std = studentService.updateStudent(id, student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@DeleteMapping("/estudiante/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer studentId) {
		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
