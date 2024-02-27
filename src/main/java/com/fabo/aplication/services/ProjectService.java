package com.fabo.aplication.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.fabo.aplication.models.Project;
import com.fabo.aplication.utils.DatabaseConnection;

public class ProjectService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ProjectService() {
		con = DatabaseConnection.getConnection();
		ps = null;
		rs = null;
	}
	
	public ArrayList<Project> extraerProyectos(){
		ArrayList<Project> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM proyecto_cod_nombre");
			while (resultado.next()) {
				int id = resultado.getInt("codpyto");
				String nombre = resultado.getString("nompyto");
				Project c1 = new Project(id, nombre);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}
}
