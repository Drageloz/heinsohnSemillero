package com.hbt.semillero.dto;

import com.hbt.semillero.interfaces.IInterfaceEjemploLocal;

public class Cuadrado extends Figura implements IInterfaceEjemploLocal {
	
	
	public Cuadrado(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return this.getBase()*this.getAltura();
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.getBase()*this.getAltura()*2;
	}

}
