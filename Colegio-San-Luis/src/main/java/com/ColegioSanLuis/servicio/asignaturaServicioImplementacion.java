/**
 * 
 */
package com.ColegioSanLuis.servicio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;

import com.ColegioSanLuis.Modelo.asignatura;
import com.ColegioSanLuis.Modelo.estudiante;
import com.ColegioSanLuis.dto.asignaturaDTO;
import com.ColegioSanLuis.dto.estudianteDTO;
import com.ColegioSanLuis.repositorio.asignaturaInterfaceRepo;
import com.ColegioSanLuis.repositorio.estudianteInterfaceRepo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CARLOS
 *
 */
@Getter
@Setter
public class asignaturaServicioImplementacion implements asignaturaInterfaceService {

	@Resource
	private asignaturaInterfaceRepo courseRepository;

	@Resource

	@Override
	public asignaturaDTO addAsignatura(asignaturaDTO Dto) {
		asignatura courses = new asignatura();
		mapDtoToEntity(Dto, courses);
		asignatura savedCourse = courseRepository.save(courses);
		return mapEntityToDto(savedCourse);
	}

	@Override
	public List<asignaturaDTO> getAllAsignaturas() {
		List<asignaturaDTO> courseDtos = new ArrayList<>();
		List<asignatura> students = courseRepository.findAll();
		students.stream().forEach(course -> {
			asignaturaDTO courseDto = mapEntityToDto(course);
			courseDtos.add(courseDto);
		});
		return courseDtos;
	}

	@Override
	public asignaturaDTO updateAsignatura(Integer coursetId, asignaturaDTO course) {
		asignatura ast = courseRepository.getOne(coursetId);
		ast.getCourses().clear();
		mapDtoToEntity(course, ast);
		asignatura es = courseRepository.save(ast);
		return mapEntityToDto(es);
	}

	@Override
	public String deleteAsignatura(Integer courseId) {
		Optional<asignatura> co = courseRepository.findById(courseId);
		// Remove the related courses from student entity.
		if (co.isPresent()) {
			co.get().removeCourses();
			courseRepository.deleteById(co.get().getCodAsignatura());
			return "Student with id: " + courseId + " deleted successfully!";
		}
		return null;
	}

	private asignaturaDTO mapEntityToDto(asignatura savedCourse) {
		asignaturaDTO responseDto = new asignaturaDTO();
		responseDto.setNomAsignatura(savedCourse.getNomAsignatura());
		responseDto.setCodAsignatura(savedCourse.getCodAsignatura());
		return responseDto;
	}

	private void mapDtoToEntity(asignaturaDTO dto, asignatura courses) {

		courses.setNomAsignatura(dto.getNomAsignatura());
		
		courses.setCodAsignatura(dto.getCodAsignatura());
		
	}

}
