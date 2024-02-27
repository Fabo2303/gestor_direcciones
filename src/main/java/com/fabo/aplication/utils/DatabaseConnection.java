package com.fabo.aplication.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
  public static Connection getConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String myDB = "jdbc:mysql://localhost:3306/nombre_de_tu_base_de_datos";
      String usuario = "tu_usuario";
      String password = "tu_contraseña";
      return DriverManager.getConnection(myDB, usuario, password);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
