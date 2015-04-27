package fr.fablabmars.model.bdd;

import java.sql.Connection;

/**
 * Classe abstraite modélisant un objet d'accès aux données.
 * 
 * @author Guillaume Perouffe
 *
 * @param <T>
 */
public abstract class DAO<T> {
	
	/**
	 * Connection à la BDD
	 */
	protected Connection connect = null;
	   
	/**
	 * Constructeur de l'objet d'accès aux données
	 * 
	 * @param conn
	 * 			Connection à la BDD
	 */
	public DAO(Connection conn){
		this.connect = conn;
	}

	/**
	 * Création d'une entrée dans la BDD
	 * 
	 * @param obj
	 * 			Objet à enregistrer
	 * @return 
	 * 			True si la création a réussi, False sinon
	 */
	public abstract boolean create(T obj);

	/**
	 * Suppression d'une entrée dans la BDD
	 * 
	 * @param obj
	 * 			Objet à supprimer
	 * @return	
	 * 			True si la suppression a réussi, False sinon
	 */
	public abstract boolean delete(T obj);
	
	/**
	 * Mise à jour d'une entrée dans la BDD
	 * 
	 * @param obj
	 * 			Objet à mettre à jour
	 * @return	 
	 * 			True si la mise à jour a réussi, False sinon
	 */
	public abstract boolean update(T obj);

	/**
	 * Chargement d'une entrée de la BDD
	 * 
	 * @param id
	 * 			ID de l'entrée à charger
	 * @return
	 * 			Objet chargé
	 */
	public abstract T load(int id);
}
