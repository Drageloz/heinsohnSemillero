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
@Table(name = "PERSONA")
public class Comprador implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_ID_GENERATOR", sequenceName = "SEC_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_ID_GENERATOR")
	@Column(name = "PERSONA_ID")
	private Long id;
	
	@Column(name = "PERSONA_NOMBRE")
	private String nombre;
	
	@Column(name = "PERSONA_TIPO_DOCUMENTO")
	@Enumerated(value = EnumType.STRING)
	private IdentificacionEnum tipoDocumento;
	
	@Column(name = "PERSONA_NUMERO_DOCUMENTO")
	private Long numeroDocumento;
	
	@Column(name = "PERSONA_FECHA_NACIMIENTO")
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
	
	

	

		
}
