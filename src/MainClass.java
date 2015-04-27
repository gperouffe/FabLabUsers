

import java.sql.Connection;

import fr.fablabmars.model.dao.ConnectionFabLab;
import fr.fablabmars.vue.Fenetre;

public class MainClass {

	public static void main(String[] args) {
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		new Fenetre() ;
	}
	
}