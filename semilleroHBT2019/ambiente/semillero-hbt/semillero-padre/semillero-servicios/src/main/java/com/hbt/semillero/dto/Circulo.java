package com.hbt.semillero.dto;

import com.hbt.semillero.interfaces.IInterfaceEjemploLocal;

public class Circulo extends Figura implements IInterfaceEjemploLocal{
	
	public Circulo(double radio) {
		super(radio);
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.PI*this.getRadio();
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI*this.getRadio()*this.getRadio();
	}
	
	
}
