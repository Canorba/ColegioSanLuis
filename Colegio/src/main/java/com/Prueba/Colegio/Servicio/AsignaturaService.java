package com.Prueba.Colegio.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba.Colegio.Modelo.Asignatura;
import com.Prueba.Colegio.Repositorio.AsignaturaRepository;

@Service
public class AsignaturaService {

	@Autowired
    private AsignaturaRepository asignaturaRepository;

    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura createAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura updateAsignatura(Long id, Asignatura asignaturaDetails) {
        Optional<Asignatura> asignaturaOpt = asignaturaRepository.findById(id);
        if (asignaturaOpt.isPresent()) {
            Asignatura asignatura = asignaturaOpt.get();
            asignatura.setNombre(asignaturaDetails.getNombre());
            asignatura.setDocente(asignaturaDetails.getDocente());
            return asignaturaRepository.save(asignatura);
        }
        return null;
    }

    public void deleteAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}