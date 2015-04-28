package fr.fablabmars.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFabLab{

	  private static String url = "jdbc:mysql://localhost:3306/gestionfablab";
	  private static String user = "fablab";
	  private static String passwd = "fablabobdd";
	  private static Connection connect;
	  
	  public static Connection getInstance(){
		    if(connect == null){
		      try {
		    	  connect = DriverManager.getConnection(url, user, passwd);
		       
		      } catch (SQLException e) {
		    	  e.printStackTrace();
		      }
		    }		
		    return connect;	
		  }
	}
