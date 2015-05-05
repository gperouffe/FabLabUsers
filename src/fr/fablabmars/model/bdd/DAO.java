package fr.fablabmars.model.bdd;

import java.sql.Connection;

/**
 * Classe abstraite mod�lisant un objet d'acc�s aux donn�es.
 * 
 * @author Guillaume Perouffe
 *
 * @param <T>
 */
public abstract class DAO<T> {
	
	/**
	 * Connection � la BDD
	 */
	protected Connection connect = null;
	   
	/**
	 * Constructeur de l'objet d'acc�s aux donn�es
	 * 
	 * @param conn
	 * 			Connection � la BDD
	 */
	public DAO(Connection conn){
		this.connect = conn;
	}

	/**
	 * Cr�ation d'une entr�e dans la BDD
	 * 
	 * @param obj
	 * 			Objet � enregistrer
	 * @return 
	 * 			True si la cr�ation a r�ussi, False sinon
	 */
	public abstract boolean create(T obj);

	/**
	 * Suppression d'une entr�e dans la BDD
	 * 
	 * @param obj
	 * 			Objet � supprimer
	 * @return	
	 * 			True si la suppression a r�ussi, False sinon
	 */
	public abstract boolean delete(T obj);
	
	/**
	 * Mise � jour d'une entr�e dans la BDD
	 * 
	 * @param obj
	 * 			Objet � mettre � jour
	 * @return	 
	 * 			True si la mise � jour a r�ussi, False sinon
	 */
	public abstract boolean update(T obj);

	/**
	 * Chargement d'une entr�e de la BDD
	 * 
	 * @param id
	 * 			ID de l'entr�e � charger
	 * @return
	 * 			Objet charg�
	 */
	public abstract T load(int id);
}
