/**
 * 
 */
package com.ColegioSanLuis.servicio;

import java.util.List;

import com.ColegioSanLuis.dto.asignaturaDTO;


/**
 * @author CARLOS
 *
 */
public interface asignaturaInterfaceService {

	public asignaturaDTO addAsignatura(asignaturaDTO Dto);
    public List <asignaturaDTO> getAllAsignaturas();
    public asignaturaDTO updateAsignatura(Integer coursetId, asignaturaDTO course);
    public String deleteAsignatura(Integer courseId);
}
