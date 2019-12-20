package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import org.apache.log4j.Logger;

import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.IdentificacionEnum;



/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un Comprador
 * 
 * @author drageloz
 */
public class CompradorDTO implements Serializable{
	
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);
	private static final long serialVersionUID = 1L;
	private Long id;
	
	private String nombre;
	private IdentificacionEnum tipoDocumento;
	private Long numeroDocumento;
	private LocalDate fechaNacimiento;

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public IdentificacionEnum getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(IdentificacionEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public Long getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static CompradorDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, CompradorDTO.class);
	}
	
	
	/**
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
	
}
