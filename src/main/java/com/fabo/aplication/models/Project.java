package com.fabo.aplication.models;

// Solo se tomara en cuenta para extraer el codpyto y el Nompyto 
public class Project {
	private int codPyto;
	private String nomPyto;
	
	public Project(int codPyto, String nomPyto) {
		super();
		this.codPyto = codPyto;
		this.nomPyto = nomPyto;
	}
	public int getCodPyto() {
		return codPyto;
	}
	public void setCodPyto(int codPyto) {
		this.codPyto = codPyto;
	}
	public String getNomPyto() {
		return nomPyto;
	}
	public void setNomPyto(String nomPyto) {
		this.nomPyto = nomPyto;
	}
	
	public Project buscarProyecto(String nom) {
		if(nomPyto.equals(nom))
			return this;
		return null;
	}
}
