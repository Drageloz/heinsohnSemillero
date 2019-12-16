package com.hbt.semillero.interfaces;

import javax.ejb.Local;

/**
 * Expone los métodos del EJB ConsultaIva Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author drageloz
 *
 */


@FunctionalInterface
@Local
public interface IInterfaceIvaLocal {
	public void calcularPrecio();
}