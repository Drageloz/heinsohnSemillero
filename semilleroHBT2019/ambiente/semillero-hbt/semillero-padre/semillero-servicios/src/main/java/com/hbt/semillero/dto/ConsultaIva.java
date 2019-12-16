package com.hbt.semillero.dto;

import org.apache.log4j.Logger;

import com.hbt.semillero.ejb.GestionarComicBean;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.interfaces.IInterfaceIvaLocal;
/**
 * Clase encargada de agregar a la clase padre comic, los valores de iva segun su temática
 * y de generar el precio total teniendo en cuenta este iva
 * 
 * @author drageloz
 *
 */
public class ConsultaIva extends Comic implements IInterfaceIvaLocal {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(GestionarComicBean.class);

	private Double total;
	private Comic comic;
	
	
	
	/**
	 * Metodo constructor que recibe el comic que se desea transformar a DTO desde 
	 * GestionarComicBean
	 * 
	 * @param comic El comic asociado a la clase.
	 */
	public ConsultaIva(Comic comic) {
		this.comic = comic;
		consultaIva();
		calcularPrecio();
	}

	/**
	 * Metodo encargado de setear el valor del atributo iva en el objeto comic
	 * 
	 */
	public void consultaIva() {
		switch(comic.getTematicaEnum().getCodigoMensaje()) {
		case "enum.tematica.aventuras":
			comic.setIva(5.0);
			break;
			
		case "enum.tematica.fantastico":
			comic.setIva(5.0);
			break;
		default:
			comic.setIva(12.5);
			break;
		}
		
	}

	
	/**
	 * Metodo encargado de setear el valor del atributo precioTotal en el objeto comic
	 * 
	 */
	@Override
	public void calcularPrecio() {
		logger.debug("esto es carnal:"+ comic.getPrecio().doubleValue());
		total = comic.getPrecio().doubleValue() + comic.getPrecio().doubleValue() * comic.getIva()/100;
		comic.setPrecioTotal(total);
	}	
	
}
