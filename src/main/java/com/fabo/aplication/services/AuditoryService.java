package com.fabo.aplication.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.fabo.aplication.models.Auditory;
import com.fabo.aplication.utils.DatabaseConnection;

public class AuditoryService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public AuditoryService() {
		con = DatabaseConnection.getConnection();
		ps = null;
		rs = null;
	}
	
	public ArrayList<Auditory> extraerRegistros(String vista){
		ArrayList<Auditory> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM vista_" + vista);
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String origen = resultado.getString("tabla_afectada");
				Date fecha = resultado.getDate("fecha_accion"); 
				String accion = resultado.getString("accion");
				Auditory c1 = new Auditory(id, origen, fecha.toString(), accion);
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
