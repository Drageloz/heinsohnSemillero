package com.hbt.semillero.interfaces;

import javax.ejb.Local;


@FunctionalInterface
@Local
public interface IInterfaceEjemploLocal {
	public double calcularArea();
}
