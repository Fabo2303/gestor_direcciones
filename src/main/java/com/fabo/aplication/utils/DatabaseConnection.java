package com.fabo.aplication.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
  public static Connection getConnection() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); // DRIVER DE SQL DEVELOPER
      String myDB = "jdbc:oracle:thin:@localhost:1521:XE";// URL DE SQL DEVELOPER
      String usuario = "SCGPDESA";
      String password = "123";
      return DriverManager.getConnection(myDB, usuario, password);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
