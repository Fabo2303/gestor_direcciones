package com.fabo.aplication.services;

import java.sql.*;
import java.util.ArrayList;

import com.fabo.aplication.models.Image;
import com.fabo.aplication.utils.ClobConverter;
import com.fabo.aplication.utils.DatabaseConnection;

public class ImageService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ImageService() {
		con = DatabaseConnection.getConnection();
		ps = null;
		rs = null;
	}

	public void agregar(Image v) {
		try {
			CallableStatement statement = con.prepareCall("{call inserts.insertar_imagen(?, ?, ?, ?, ?)}");
			Clob cadenaLarga = con.createClob();
			cadenaLarga.setString(1, v.getDescripcion());
			statement.setString(1, v.getTitulo());
			statement.setClob(2, cadenaLarga);
			statement.setInt(3, v.getId_proy());
			statement.setString(4, v.getUrl());
			statement.setInt(5, 1);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(Image v) {
		try {
			CallableStatement statement = con.prepareCall("{call updates.update_imagen(?, ?, ?, ?, ?, ?, ?)}");
			Clob cadenaLarga = con.createClob();
			cadenaLarga.setString(1, v.getDescripcion());
			statement.setInt(1, v.getId());
			statement.setString(2, v.getTitulo());
			statement.setClob(3, cadenaLarga);
			statement.setInt(4, v.getId_proy());
			statement.setInt(5, v.getId_cia());
			statement.setString(6, v.getUrl());
			statement.setInt(7, v.getVisualizacion());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Image> extraerRegistros() {
		ArrayList<Image> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_todo");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Image c1 = new Image(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}

	public ArrayList<Image> extraerVisualizables() {
		ArrayList<Image> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_visual_uno");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Image c1 = new Image(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}

	public ArrayList<Image> extraerNoVisualizables() {
		ArrayList<Image> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_visual_cero");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Image c1 = new Image(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
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
