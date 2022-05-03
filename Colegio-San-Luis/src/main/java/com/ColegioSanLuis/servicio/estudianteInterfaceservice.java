/**
 * 
 */
package com.ColegioSanLuis.servicio;

import com.ColegioSanLuis.dto.estudianteDTO;

import java.util.List;

/**
 * @author CARLOS
 *
 */
public interface estudianteInterfaceservice {

	public estudianteDTO addStudent(estudianteDTO studentDto);
    public List <estudianteDTO> getAllStudents();
    public estudianteDTO updateStudent(Integer studentId, estudianteDTO student);
    public String deleteStudent(Integer studentId);
}
