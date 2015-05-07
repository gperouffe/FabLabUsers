package fr.fablabmars.model.bdd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	 * Fichier de sauvegarde dernière connexion
	 */
	private static File saved = new File("ressources/infoserv.txt");
	
	/**
	 * URL de connection BDD
	 */
	private static String url = "";
	
	/**
	 * Utilisateur BDD
	 */
	private static String user = "";
	
	/**
	 * Mot de passe BDD
	 */
	private static String passwd = "";
	
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
				return null;
			}	
		}		
		passwd="";
		return connect;
	}

	public static String getUrl() {
		if(url ==""){
			BufferedReader bfr=null;
			try{
				bfr = new BufferedReader(new FileReader(saved));
				url = bfr.readLine();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try{
					if(bfr!=null){
						bfr.close();
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return url;
	}

	public static void setUrl(String url) {
		ConnectionFabLab.url = url;
		BufferedWriter bfw=null;
		try{
			bfw = new BufferedWriter(new FileWriter(saved));
			bfw.write(url);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(bfw!=null){
					bfw.flush();
					bfw.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		connect = null;
	}

	public static String getUser() {
		if(user ==""){
			BufferedReader bfr=null;
			try{
				bfr = new BufferedReader(new FileReader(saved));
				bfr.readLine();
				user = bfr.readLine();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				try{
					if(bfr!=null){
						bfr.close();
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	public static void setUser(String user) {
		ConnectionFabLab.user = user;
		BufferedWriter bfw=null;
		try{
			bfw = new BufferedWriter(new FileWriter(saved));
			bfw.write(url);
			bfw.newLine();
			bfw.write(user);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(bfw!=null){
					bfw.flush();
					bfw.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		connect = null;
	}
	
	public static void setPasswd(String passwd) {
		ConnectionFabLab.passwd = passwd;
		connect = null;
	}
}
