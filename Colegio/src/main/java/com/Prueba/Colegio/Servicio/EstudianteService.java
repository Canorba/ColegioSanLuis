package com.Prueba.Colegio.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba.Colegio.Modelo.Estudiante;
import com.Prueba.Colegio.Repositorio.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public List<Estudiante> getAllEstudiantes() {
		return estudianteRepository.findAll();
	}

	public Optional<Estudiante> getEstudianteById(Long id) {
		return estudianteRepository.findById(id);
	}

	public Estudiante createEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	public Estudiante updateEstudiante(Long id, Estudiante estudianteDetails) {
		Optional<Estudiante> estudianteOpt = estudianteRepository.findById(id);
		if (estudianteOpt.isPresent()) {
			Estudiante estudiante = estudianteOpt.get();
			estudiante.setTipoDocumento(estudianteDetails.getTipoDocumento());
			estudiante.setNumeroDocumento(estudianteDetails.getNumeroDocumento());
			estudiante.setNombres(estudianteDetails.getNombres());
			estudiante.setApellidos(estudianteDetails.getApellidos());
			estudiante.setFechaNacimiento(estudianteDetails.getFechaNacimiento());
			estudiante.setGrado(estudianteDetails.getGrado());
			estudiante.setCiudadResidencia(estudianteDetails.getCiudadResidencia());
			estudiante.setDireccionResidencia(estudianteDetails.getDireccionResidencia());
			estudiante.setEmail(estudianteDetails.getEmail());
			estudiante.setTelefonoFijo(estudianteDetails.getTelefonoFijo());
			estudiante.setCelular(estudianteDetails.getCelular());
			estudiante.setNombreAcudiente(estudianteDetails.getNombreAcudiente());
			return estudianteRepository.save(estudiante);
		}
		return null;
	}

	public void deleteEstudiante(Long id) {
		estudianteRepository.deleteById(id);
	}
}