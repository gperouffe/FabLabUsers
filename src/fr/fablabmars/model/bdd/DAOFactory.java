package fr.fablabmars.model.bdd;

import java.sql.Connection;

/**
 * Fabrique d'objets d'acc�s aux donn�es MySQL
 *  
 * @author Guillaume Perouffe
 *
 */
public class DAOFactory {
	
	/**
	 * Connection � la BDD MySQL du Fablab
	 * 
	 * @see ConnectionFabLab
	 */
	protected static final Connection conn = ConnectionFabLab.getInstance();
	
	/**
	 * Fabrication d'un UtilisateurDAO
	 * 
	 * @return Nouvel UtilisateurDAO
	 * 
	 * @see UtilisateurDAO
	 */
	public static UtilisateurDAO getDAOUtilisateur(){
		return new UtilisateurDAO(conn);
	}
}
