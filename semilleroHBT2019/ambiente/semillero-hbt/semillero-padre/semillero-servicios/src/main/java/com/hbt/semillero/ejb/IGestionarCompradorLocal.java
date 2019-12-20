package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.CompradorDTO;


/**
 * Expone los métodos del EJB GestionarComprador Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author drageloz
 *
 */
@Local
public interface IGestionarCompradorLocal {
	
	/**
	 * 
	 * Metodo encargado de crear un comprador y persistirlo
	 * 
	 * @author drageloz
	 * 
	 * @param compradorDTO informacion nueva a crear
	 */
	public void crearComprador(CompradorDTO compradorDTO);

	
	/**
	 * 
	 * Metodo encargado de consultar un comprador, modificarlo y guardarlo
	 * 
	 * @author drageloz
	 * 
	 * @param id, nombre, compradorDTO informacion nueva a modificar
	 */
	public void modificarComprador(Long id, String nombre,CompradorDTO compradorDTO);

	
	/**
	 * 
	 * Metodo encargado de eliminar un comprador, modificarlo y guardarlo
	 * 
	 * @author drageloz
	 * 
	 * @param idComprador informacion del id del comprador a eliminar
	 */
	public void eliminarComprador(Long idComprador);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un comprador
	 * 
	 * @return List<CompradorDTO> Resultado de la consulta
	 */
	public  List<CompradorDTO> consultarComprador();
	
	/**
	 * 
	 * Metodo encargado de retornar una lista de compradores 
	 * @param idPersonaje El id del personaje a consultar
	 * @return List<CompradorDTO> Resultado de la consulta
	 */
	public List<CompradorDTO>  consultarCompradores(Long idPersonaje);
	
}
