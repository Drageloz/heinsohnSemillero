package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;

/* Se comentan los @param de cada método para poder reutilizarlos sea el caso en un futuro, de lo contrario, en futuros
 * commits, estos serán eliminadas del archivo.
 */

/**
 * Expone los métodos del EJB GestionarComic Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author ccastano
 *
 */
@Local
public interface IGestionarPersonajeLocal {

	/**
	 * 
	 * Metodo encargado de crear un personaje y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * --@param comicNuevo informacion nueva a crear
	 */
	public void crearPersonaje();

	/**
	 * 
	 * Metodo encargado de consultar un personaje modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * --@param comicModificar informacion nueva a modificar
	 */
	public void modificarPersonaje();

	/**
	 * 
	 * Metodo encargado de eliminar un personaje modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * --@param comicEliminar informacion a eliminar
	 */
	public void eliminarPersonaje();

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un personaje
	 * 
	 * --@param idComic identificador del comic a ser consultado
	 * @return personaje Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public ComicDTO consultarPersonaje();

	/**
	 * 
	 * Metodo encargado de retornar una lista de personajes
	 * 
	 * @return
	 */
	public List<ComicDTO> consultarPersonajes();
}
