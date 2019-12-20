/**
 * GestionarCompraBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
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
import com.hbt.semillero.dto.ConsultaIva;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Compra;
import com.hbt.semillero.entidad.Personaje;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los compras
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraBean implements IGestionarCompraLocal {
	final static Logger logger = Logger.getLogger(GestionarCompraBean.class);
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraLocal#crearCompra(com.hbt.semillero.dto.CompraDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearCompra(CompraDTO compraNuevo) {
		// Entidad nueva
		Compra compra = convertirCompraDTOToCompra(compraNuevo);
		// Se almacena la informacion y se maneja la enidad compra
		em.persist(compra);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraLocal#modificarCompra(com.hbt.semillero.dto.CompraDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarCompra(Long id, String nombre, CompraDTO compraNuevo) {
//		Compra compraModificar ;
//		if(compraNuevo==null) {
//			// Entidad a modificar
//			compraModificar = em.find(Compra.class, id);
//		}else {
//			compraModificar = convertirCompraDTOToCompra(compraNuevo);
//		}
//		compraModificar.setNombre(nombre);
//		em.merge(compraModificar);
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraLocal#eliminarCompra(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCompra(Long idCompra) {
		Compra compraEliminar = em.find(Compra.class, idCompra);
		if (compraEliminar != null) {
			em.remove(compraEliminar);
		}
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraLocal#consultarCompra(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CompraDTO consultarCompra(String idCompra) {
		Compra compra = null;
		compra = new Compra();
		compra = em.find(Compra.class, Long.parseLong(idCompra));
		CompraDTO compraDTO = convertirCompraToCompraDTO(compra);
		return compraDTO;
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarCompraLocal#consultarCompras()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<CompraDTO> consultarCompras() {
		logger.debug("se ejecuta el método consultar compras");
		List<CompraDTO> resultadosCompraDTO = new ArrayList<CompraDTO>();
		List<Compra> resultados = em.createQuery("select c from Compra c").getResultList();
		for (Compra compra:resultados) {
			resultadosCompraDTO.add(convertirCompraToCompraDTO(compra));
		}
		return resultadosCompraDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un compra a un compraDTO
	 * 
	 * @param compra
	 * @return
	 */
	private CompraDTO convertirCompraToCompraDTO(Compra compra) {
		
		CompraDTO compraDTO = new CompraDTO();
//		ConsultaIva precioIva = new ConsultaIva(compra);
//		
//		if(compra.getId()!=null) {
//		 compraDTO.setId(compra.getId().toString());
//		}
//		compraDTO.setNombre(compra.getNombre());
//		compraDTO.setEditorial(compra.getEditorial());
//		compraDTO.setTematicaEnum(compra.getTematicaEnum());
//		compraDTO.setColeccion(compra.getColeccion());
//		compraDTO.setNumeroPaginas(compra.getNumeroPaginas());
//		compraDTO.setPrecio(compra.getPrecio());
//		compraDTO.setAutores(compra.getAutores());
//		compraDTO.setColor(compra.getColor());
//		compraDTO.setFechaVenta(compra.getFechaVenta());
//		compraDTO.setEstadoEnum(compra.getEstadoEnum());
//		compraDTO.setCantidad(compra.getCantidad());
//		compraDTO.setIva(compra.getIva());
//		compraDTO.setPrecioTotal(compra.getPrecioTotal());
//		return compraDTO;
		return null;
	}

	/**
	 * 
	 * Metodo encargado de transformar un compraDTO a un compra
	 * 
	 * @param compra
	 * @return
	 */
	private Compra convertirCompraDTOToCompra(CompraDTO compraDTO) {
		Compra compra = new Compra();
		compra.setIdComic(new Comic());
		compra.getIdComic().setId(compraDTO.getIdComic());
		compra.setIdPersona(new Personaje());
		compra.getIdPersona().setId(compraDTO.getIdPersona());
		compra.setFechaVenta(LocalDate.now());
		
//		if(compraDTO.getId()!=null) {
//			compra.setId(Long.parseLong(compraDTO.getId()));
//		}
//		compra.setNombre(compraDTO.getNombre());
//		compra.setEditorial(compraDTO.getEditorial());
//		compra.setTematicaEnum(compraDTO.getTematicaEnum());
//		compra.setColeccion(compraDTO.getColeccion());
//		compra.setNumeroPaginas(compraDTO.getNumeroPaginas());
//		compra.setPrecio(compraDTO.getPrecio());
//		compra.setAutores(compraDTO.getAutores());
//		compra.setColor(compraDTO.getColor());
//		compra.setFechaVenta(compraDTO.getFechaVenta());
//		compra.setEstadoEnum(compraDTO.getEstadoEnum());
//		compra.setCantidad(compraDTO.getCantidad());
		return compra;
	}

	@Override
	public List<CompraDTO> consultarCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompraDTO> consultarCompras(Long idPersonaje) {
		// TODO Auto-generated method stub
		return null;
	}
}
