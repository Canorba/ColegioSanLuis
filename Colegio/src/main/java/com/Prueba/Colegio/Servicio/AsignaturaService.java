package com.Prueba.Colegio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba.Colegio.Modelo.Asignatura;
import com.Prueba.Colegio.Modelo.Docente;
import com.Prueba.Colegio.Repositorio.AsignaturaRepository;
import com.Prueba.Colegio.Repositorio.DocenteRepository;

@Service
public class AsignaturaService {

	@Autowired
    private AsignaturaRepository asignaturaRepository;
	@Autowired
    private DocenteRepository docenteRepository;
	
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura createAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura updateAsignatura(Long id, Asignatura asignatura) {
        Asignatura existingAsignatura = asignaturaRepository.findById(id)
                .orElseThrow();

        Docente docente = docenteRepository.findById(asignatura.getDocente().getId())
                .orElseThrow();

        existingAsignatura.setNombre(asignatura.getNombre());
        existingAsignatura.setDocente(docente);

        return asignaturaRepository.save(existingAsignatura);
    }

    public void deleteAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}