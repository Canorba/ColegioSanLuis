package com.Prueba.Colegio.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Prueba.Colegio.Modelo.Estudiante;
import com.Prueba.Colegio.Servicio.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@GetMapping
	public List<Estudiante> getAllEstudiantes() {
		return estudianteService.getAllEstudiantes();
	}

	@GetMapping("/{id}")
	public Optional<Estudiante> getEstudianteById(@PathVariable Long id) {
		return estudianteService.getEstudianteById(id);
	}

	@PostMapping
	public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteService.createEstudiante(estudiante);
	}

	@PutMapping("/{id}")
	public Estudiante updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetails) {
		return estudianteService.updateEstudiante(id, estudianteDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteEstudiante(@PathVariable Long id) {
		estudianteService.deleteEstudiante(id);
	}
}