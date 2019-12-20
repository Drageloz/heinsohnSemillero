package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPRA")
public class Compra implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMPRA_ID_GENERATOR", sequenceName = "SEC_COMPRA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPRA_ID_GENERATOR")
	@Column(name = "COMPRA_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_COMIC_COMPRADO")
	private Comic idComic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_ID_PERSONA")
	private Personaje idPersona;
	
	@Column(name = "COMPRA_FECHA_VENTA")
	private LocalDate fechaVenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comic getIdComic() {
		return idComic;
	}

	public void setIdComic(Comic idComic) {
		this.idComic = idComic;
	}

	public Personaje getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Personaje idPersona) {
		this.idPersona = idPersona;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

		
		
}
