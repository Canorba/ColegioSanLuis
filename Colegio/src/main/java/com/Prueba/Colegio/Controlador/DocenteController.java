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

import com.Prueba.Colegio.Modelo.Docente;
import com.Prueba.Colegio.Servicio.DocenteService;

@RestController
@RequestMapping("/docentes")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;

	@GetMapping
	public List<Docente> getAllDocentes() {
		return docenteService.getAllDocentes();
	}

	@GetMapping("/{id}")
	public Optional<Docente> getDocenteById(@PathVariable Long id) {
		return docenteService.getDocenteById(id);
	}

	@PostMapping
	public Docente createDocente(@RequestBody Docente docente) {
		return docenteService.createDocente(docente);
	}

	@PutMapping("/{id}")
	public Docente updateDocente(@PathVariable Long id, @RequestBody Docente docenteDetails) {
		return docenteService.updateDocente(id, docenteDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteDocente(@PathVariable Long id) {
		docenteService.deleteDocente(id);
	}
}