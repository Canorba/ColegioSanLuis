/**
 * 
 */
package com.ColegioSanLuis.servicio;

import java.util.List;

import com.ColegioSanLuis.dto.estudianteDTO;
import com.ColegioSanLuis.dto.profesorDTO;

/**
 * @author CARLOS
 *
 */
public interface profesorServicioInterface {

	public profesorDTO addProfesor(profesorDTO teacherDto);
    public List <profesorDTO> getAllprofesor();
    public profesorDTO updateTeacher(Integer teacherId, profesorDTO teacher);
    public String deleteProfesor(Integer teacherId);
}
