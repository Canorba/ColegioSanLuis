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

import com.ColegioSanLuis.Modelo.asignatura;
import com.ColegioSanLuis.Modelo.profesor;
import com.ColegioSanLuis.dto.profesorDTO;
import com.ColegioSanLuis.repositorio.asignaturaInterfaceRepo;
import com.ColegioSanLuis.repositorio.profesorInterfaceRepo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author CARLOS
 *
 */
@Getter
@Setter
public class profesorServicioImplementacion implements profesorServicioInterface{
	
	@Resource
    private profesorInterfaceRepo teacherRepository;
    @Resource
    private asignaturaInterfaceRepo courseRepository;
    @Transactional

	@Override
	public profesorDTO addProfesor(profesorDTO teacherDto) {
    	profesor teacher = new profesor();
        mapDtoToEntity(teacherDto, teacher);
        profesor savedTeacher = teacherRepository.save(teacher);
        return mapEntityToDto(savedTeacher);
	}

	@Override
	public List<profesorDTO> getAllprofesor() {
		List<profesorDTO> profesorDTO = new ArrayList<>();
        List<profesor> profe = teacherRepository.findAll();
        profe.stream().forEach(teacher -> {
        	profesorDTO teacherDto = mapEntityToDto(teacher);
        	profesorDTO.add(teacherDto);
        });
        return profesorDTO;
	}

	@Override
	public profesorDTO updateTeacher(Integer teacherId, profesorDTO teacher) {
		    profesor pf = teacherRepository.getOne(teacherId);
		    pf.getCourses().clear();
	        mapDtoToEntity(teacher, pf);
	        profesor es = teacherRepository.save(pf);
	        return mapEntityToDto(es);
	}

	@Override
	public String deleteProfesor(Integer studentId) {
		 Optional<profesor> teach = teacherRepository.findById(studentId);
	        //Remove the related courses from student entity.
	        if(teach.isPresent()) {
	        	teach.get().removeCourses();
	        	teacherRepository.deleteById(teach.get().getIdProfesor());
	            return "Student with id: " + studentId + " deleted successfully!";
	        }
	        return null;
	}

	private void mapDtoToEntity(profesorDTO teachDto, profesor teach) {
		teach.setNombre(teachDto.getNombre());
        if (null == teach.getCourses()) {
        	teach.setCourses(new HashSet<>());
        }
        teachDto.getAsignatura().stream().forEach(courseName -> {
            asignatura course = courseRepository.findByName(courseName);
            if (null == course) {
                course = new asignatura();
                course.setTeacher(new HashSet<>());
            }
            course.setNomAsignatura(courseName);
            teach.addCourse(course);
            
        });
    }
    private profesorDTO mapEntityToDto(profesor teache) {
    	profesorDTO responseDto = new profesorDTO();
        responseDto.setNombre(teache.getNombre());
        responseDto.setNumIdentificacion(teache.getIdProfesor());
        responseDto.setAsignatura(teache.getCourses().stream().map(asignatura::getNomAsignatura).collect(Collectors.toSet()));
        return responseDto;
    }
}
