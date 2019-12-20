/**
 * GestionarCompradorBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.CompraDTO;
import com.hbt.semillero.dto.CompradorDTO;
import com.hbt.semillero.dto.ConsultaIva;
import com.hbt.semillero.entidad.Comprador;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los compradors
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompradorBean implements IGestionarCompradorLocal {
	final static Logger logger = Logger.getLogger(GestionarCompradorBean.class);
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompradorLocal#crearComprador(com.hbt.semillero.dto.CompradorDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComprador(CompradorDTO compradorNuevo) {
		// Entidad nueva
		Comprador comprador = convertirCompradorDTOToComprador(compradorNuevo);
		// Se almacena la informacion y se maneja la enidad comprador
		em.persist(comprador);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompradorLocal#modificarComprador(com.hbt.semillero.dto.CompradorDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComprador(Long id, String nombre, CompradorDTO compradorNuevo) {
		Comprador compradorModificar ;
		if(compradorNuevo==null) {
			// Entidad a modificar
			compradorModificar = em.find(Comprador.class, id);
		}else {
			compradorModificar = convertirCompradorDTOToComprador(compradorNuevo);
		}
		compradorModificar.setNombre(nombre);
		em.merge(compradorModificar);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompradorLocal#eliminarComprador(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarComprador(Long idComprador) {
		Comprador compradorEliminar = em.find(Comprador.class, idComprador);
		if (compradorEliminar != null) {
			em.remove(compradorEliminar);
		}
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompradorLocal#consultarComprador(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CompradorDTO consultarComprador(String idComprador) {
		Comprador comprador = null;
		comprador = new Comprador();
		comprador = em.find(Comprador.class, Long.parseLong(idComprador));
		CompradorDTO compradorDTO = convertirCompradorToCompradorDTO(comprador);
		return compradorDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompradorLocal#consultarCompradors()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CompradorDTO> consultarCompradors() {
		logger.debug("se ejecuta el método consultar compradors");
		List<CompradorDTO> resultadosCompradorDTO = new ArrayList<CompradorDTO>();
		List<Comprador> resultados = em.createQuery("select c from Comprador c").getResultList();
		for (Comprador comprador:resultados) {
			resultadosCompradorDTO.add(convertirCompradorToCompradorDTO(comprador));
		}
		return resultadosCompradorDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un comprador a un compradorDTO
	 * 
	 * @param comprador
	 * @return
	 */
	private CompradorDTO convertirCompradorToCompradorDTO(Comprador comprador) {

		return null;
	}

	/**
	 * 
	 * Metodo encargado de transformar un compradorDTO a un comprador
	 * 
	 * @param comprador
	 * @return
	 */
	private Comprador convertirCompradorDTOToComprador(CompradorDTO compradorDTO) {
		Comprador comprador = new Comprador();
		comprador.setNombre(compradorDTO.getNombre());
		comprador.setTipoDocumento(compradorDTO.getTipoDocumento());
		comprador.setNumeroDocumento(compradorDTO.getNumeroDocumento());
		comprador.setFechaNacimiento(compradorDTO.getFechaNacimiento());
		return comprador;
	}

	@Override
	public List<CompradorDTO> consultarComprador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompradorDTO> consultarCompradores(Long idPersonaje) {
		// TODO Auto-generated method stub
		return null;
	}

}
