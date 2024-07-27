package com.Prueba.Colegio.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba.Colegio.Modelo.Docente;
import com.Prueba.Colegio.Repositorio.DocenteRepository;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;

	public List<Docente> getAllDocentes() {
		return docenteRepository.findAll();
	}

	public Optional<Docente> getDocenteById(Long id) {
		return docenteRepository.findById(id);
	}

	public Docente createDocente(Docente docente) {
		return docenteRepository.save(docente);
	}

	public Docente updateDocente(Long id, Docente docenteDetails) {
		Optional<Docente> docenteOpt = docenteRepository.findById(id);
		if (docenteOpt.isPresent()) {
			Docente docente = docenteOpt.get();
			docente.setTipoDocumento(docenteDetails.getTipoDocumento());
			docente.setNumeroDocumento(docenteDetails.getNumeroDocumento());
			docente.setNombres(docenteDetails.getNombres());
			docente.setApellidos(docenteDetails.getApellidos());
			docente.setFechaNacimiento(docenteDetails.getFechaNacimiento());
			docente.setGradoResponsable(docenteDetails.getGradoResponsable());
			docente.setUltimoGradoEscolaridad(docenteDetails.getUltimoGradoEscolaridad());
			docente.setEmail(docenteDetails.getEmail());
			docente.setTelefonoFijo(docenteDetails.getTelefonoFijo());
			docente.setCelular(docenteDetails.getCelular());
			return docenteRepository.save(docente);
		}
		return null;
	}

	public void deleteDocente(Long id) {
		docenteRepository.deleteById(id);
	}
}