package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;

import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Comprador;
import com.hbt.semillero.entidad.EstadoEnum;



/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un Compra
 * 
 * @author drageloz
 */
public class CompraDTO implements Serializable{
	
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);
	private Long id;
	private Long idComic;
	private Long idPersona;
	private LocalDate fechaVenta;

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdComic() {
		return idComic;
	}


	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}


	public Long getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}


	public LocalDate getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static CompraDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, CompraDTO.class);
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
