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
import com.ColegioSanLuis.Modelo.estudiante;
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
public class estudianteServicioImplementacion implements estudianteInterfaceservice{
	
	@Resource
    private estudianteInterfaceRepo studentRepository;
    @Resource
    private asignaturaInterfaceRepo courseRepository;
    @Transactional
   
	@Override
	public estudianteDTO addStudent(estudianteDTO studentDto) {
		estudiante student = new estudiante();
        mapDtoToEntity(studentDto, student);
        estudiante savedStudent = studentRepository.save(student);
        return mapEntityToDto(savedStudent);
		
	}

	@Override
	public List<estudianteDTO> getAllStudents() {
		List<estudianteDTO> studentDtos = new ArrayList<>();
        List<estudiante> students = studentRepository.findAll();
        students.stream().forEach(student -> {
        	estudianteDTO studentDto = mapEntityToDto(student);
            studentDtos.add(studentDto);
        });
        return studentDtos;
	}

	@Override
	public estudianteDTO updateStudent(Integer studentId, estudianteDTO student) {
		    estudiante std = studentRepository.getOne(studentId);
	        std.getCourses().clear();
	        mapDtoToEntity(student, std);
	        estudiante es = studentRepository.save(std);
	        return mapEntityToDto(es);
	}

	@Override
	public String deleteStudent(Integer studentId) {
		 Optional<estudiante> student = studentRepository.findById(studentId);
	        
	        if(student.isPresent()) {
	            student.get().removeCourses();
	            studentRepository.deleteById(student.get().getIdEstudiante());
	            return "Student with id: " + studentId + " deleted successfully!";
	        }
	        return null;
	}

	private void mapDtoToEntity(estudianteDTO studentDto, estudiante student) {
        student.setNombre(studentDto.getNombre());
        if (null == student.getCourses()) {
            student.setCourses(new HashSet<>());
        }
        studentDto.getAsignatura().stream().forEach(courseName -> {
            asignatura course = courseRepository.findByName(courseName);
            if (null == course) {
                course = new asignatura();
                course.setStudents(new HashSet<>());
            }
            course.setNomAsignatura(courseName);
            student.addCourse(course);
        });
    }
    private estudianteDTO mapEntityToDto(estudiante student) {
    	estudianteDTO responseDto = new estudianteDTO();
        responseDto.setNombre(student.getNombre());
        responseDto.setNumIdentificacion(student.getIdEstudiante());
        responseDto.setAsignatura(student.getCourses().stream().map(asignatura::getNomAsignatura).collect(Collectors.toSet()));
        return responseDto;
    }
}
