package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonajeDTO;
import com.hbt.semillero.dto.CompraDTO;


/**
 * Expone los métodos del EJB GestionarCompra Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author drageloz
 *
 */
@Local
public interface IGestionarCompraLocal {
	
	/**
	 * 
	 * Metodo encargado de crear un compra y persistirlo
	 * 
	 * @author drageloz
	 * 
	 * @param compraDTO informacion nueva a crear
	 */
	public void crearCompra(CompraDTO compraDTO);

	
	/**
	 * 
	 * Metodo encargado de consultar un compra, modificarlo y guardarlo
	 * 
	 * @author drageloz
	 * 
	 * @param id, nombre, compraDTO informacion nueva a modificar
	 */
	public void modificarCompra(Long id, String nombre,CompraDTO compraDTO);

	
	/**
	 * 
	 * Metodo encargado de eliminar un compra, modificarlo y guardarlo
	 * 
	 * @author drageloz
	 * 
	 * @param idCompra informacion del id del compra a eliminar
	 */
	public void eliminarCompra(Long idCompra);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un compra
	 * 
	 * @return List<CompraDTO> Resultado de la consulta
	 */
	public  List<CompraDTO> consultarCompra();
	
	/**
	 * 
	 * Metodo encargado de retornar una lista de compraes 
	 * @param idPersonaje El id del personaje a consultar
	 * @return List<CompraDTO> Resultado de la consulta
	 */
	public List<CompraDTO>  consultarCompras(Long idPersonaje);
	
}
