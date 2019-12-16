package com.hbt.semillero.dto;

public abstract class Figura {

	private double base;
	private double altura;
	private double radio;
	
	
	
	public Figura(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}


	public Figura(double radio) {
		this.radio = radio;
	}



	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public double getRadio() {
		return radio;
	}



	public void setRadio(double radio) {
		this.radio = radio;
	}



	public Figura() {
		
	}
	
	public abstract double area();

}
