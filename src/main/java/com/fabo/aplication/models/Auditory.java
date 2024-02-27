package com.fabo.aplication.models;

public class Auditory {
	private String accion;
	private String fecha; //→DD/MM/AA
	private int id;
	private String origen;
	
	public Auditory(int id, String origen,String fecha, String accion) {
		this.id = id;
		this.origen = origen;
		this.fecha = fecha;		
		this.accion = accion;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public String getAccion() {
		return accion;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public int getId() {
		return id;
	}
}
