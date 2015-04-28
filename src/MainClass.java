

import fr.fablabmars.vue.Fenetre;

public class MainClass {

	public static void main(String[] args) {
		// Chargement du driver JDBC pour MySQL
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		new Fenetre() ;
	}
	
}