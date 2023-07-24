package com.conversor.logica;

abstract class Unidad{
	
	private String nombre;
	private double proporcion;
	
	public Unidad(float proporcion, String nombre) {
		this.proporcion = (float) proporcion;
		this.nombre = nombre;
	}
	
	public double convertir(Unidad origen, float cantidad){
		return (double) this.proporcion * 1/(origen.proporcion) * cantidad;
	};
	
	public String mostrarConversion(Unidad origen, float cantidad) {
		return cantidad + " " +origen.getNombreUnidad() + " : " 
				+ this.convertir(origen, cantidad) + " " + this.nombre;
	}
	
	public String getNombreUnidad() {
		return this.nombre;
	}
	
}
