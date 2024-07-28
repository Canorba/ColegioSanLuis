package com.Prueba.Colegio.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.Colegio.Modelo.Asignatura;
import com.Prueba.Colegio.Servicio.AsignaturaService;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

	@Autowired
	private AsignaturaService asignaturaService;

	@GetMapping
	public List<Asignatura> getAllAsignaturas() {
		return asignaturaService.getAllAsignaturas();
	}

	@GetMapping("/{id}")
	public Optional<Asignatura> getAsignaturaById(@PathVariable Long id) {
		return asignaturaService.getAsignaturaById(id);
	}

	@PostMapping
	public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
		return asignaturaService.createAsignatura(asignatura);
	}

	
	 @PutMapping("/{id}")
	    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
	        try {
	            Asignatura updatedAsignatura = asignaturaService.updateAsignatura(id, asignatura);
	            return ResponseEntity.ok(updatedAsignatura);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	        }
	    }
	/*@PutMapping("/{id}")
	public Asignatura updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
		return asignaturaService.updateAsignatura(id, asignaturaDetails);
	}*/

	@DeleteMapping("/{id}")
	public void deleteAsignatura(@PathVariable Long id) {
		asignaturaService.deleteAsignatura(id);
	}
}