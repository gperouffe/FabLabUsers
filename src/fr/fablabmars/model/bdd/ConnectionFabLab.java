package fr.fablabmars.model.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton ouvrant et retenant la connection
 * 
 * @author Guillaume Perouffe
 *
 */
public class ConnectionFabLab{
	
	/**
	 * URL de connection BDD
	 */
	private static String url = "jdbc:mysql://localhost:3306/gestionfablab";
	
	/**
	 * Utilisateur BDD
	 */
	private static String user = "fablab";
	
	/**
	 * Mot de passe BDD
	 */
	private static String passwd = "fablabobdd";
	
	/**
	 * Objet connection
	 */
	private static Connection connect;
	  
	/**
	 * Instanciation de l'objet Connection
	 * 
	 * @return	Objet Connection
	 */
	public static Connection getInstance(){
		try {
			  Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
			
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
