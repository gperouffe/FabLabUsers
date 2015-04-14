package fr.fablabmars.model.dao;

import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = ConnectionFabLab.getInstance();
	
	public static UtilisateurDAO getDAOUtilisateur(){
		return new UtilisateurDAO(conn);
	}
}
