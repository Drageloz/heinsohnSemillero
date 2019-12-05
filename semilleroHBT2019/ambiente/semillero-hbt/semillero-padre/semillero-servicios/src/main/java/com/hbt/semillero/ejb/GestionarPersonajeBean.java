/**
 * GestionarComicBean.java
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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.Comic;


/* Se comentan las lineas internas de cada método para poder reutilizarlas sea el caso en un futuro, de lo contrario, en futuros
 * commits, estas serán eliminadas del archivo
 */

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * los personajes
 * 
 * @author ccastano
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonajeBean implements IGestionarPersonajeLocal {
	final static Logger logger = Logger.getLogger(GestionarPersonajeBean.class);
	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersonaje() {
		/*// Entidad nueva
		Comic comic = convertirComicDTOToComic(comicNuevo);
		// Se almacena la informacion y se maneja la entidad comic
		em.persist(comic);*/
		logger.debug("se inicia la ejecución del método crearPersonaje");
		
		logger.debug("finaliza la ejecución del método crearPersonaje");
		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarPersonaje() {
		/*Comic comicModificar ;
		if(comicNuevo==null) {
			// Entidad a modificar
			comicModificar = em.find(Comic.class, id);
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);*/
		logger.debug("se inicia la ejecución del método modificarPersonaje");
		
		logger.debug("finaliza la ejecución del método modificarPersonaje");
		
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPersonaje() {
		/*Comic comicEliminar = em.find(Comic.class, idComic);
		if (comicEliminar != null) {
			em.remove(comicEliminar);
		}*/
		
		logger.debug("se inicia la ejecución del método eliminarPersonaje");
		
		logger.debug("finaliza la ejecución del método eliminarPersonaje");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComic(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarPersonaje() {
		/*Comic comic = null;
		comic = new Comic();
		comic = em.find(Comic.class, Long.parseLong(idComic));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;*/
		
		logger.debug("se inicia la ejecución del método consultarPersonaje");
		
		logger.debug("finaliza la ejecución del método consultarPersonaje");
	}

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarPersonajes() {
		/*List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic:resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;*/
		logger.debug("se inicia la ejecución del método consultarPersonajes");
		
		logger.debug("finaliza la ejecución del método consultarPersonajes");		
	}

	/**
	 * 
	 * Metodo encargado de transformar un Personaje a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	private ComicDTO convertirPersonajeToComicDTO() {
		/*ComicDTO comicDTO = new ComicDTO();
		if(comic.getId()!=null) {
		 comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;*/
		
		logger.debug("se inicia la ejecución del método convertirPersonajeToComicDTO");
		
		logger.debug("finaliza la ejecución del método convertirPersonajeToComicDTO");

	}

	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un personaje
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToPersonaje(ComicDTO comicDTO) {
		/*Comic comic = new Comic();
		if(comicDTO.getId()!=null) {
			comic.setId(Long.parseLong(comicDTO.getId()));
		}
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;*/
		logger.debug("se inicia la ejecución del método convertirComicDTOToPersonaje");
		
		logger.debug("finaliza la ejecución del método convertirComicDTOToPersonaje");

		
	}
}
