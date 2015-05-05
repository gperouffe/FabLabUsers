package fr.fablabmars.controler.formulaire;

import fr.fablabmars.controler.AbstractControler;
import fr.fablabmars.model.bdd.DAO;
import fr.fablabmars.model.bdd.QueryResult;

/**
 * Classe abstraite représentant un controleur de formulaire
 * 
 * @author Guillaume Perouffe
 * @see AbstractControler
 * @param T
 * 			Type des données reçues depuis la vue
 */
public abstract class FormulaireAbstractControler<T> extends AbstractControler {
	
	/**
	 * Objet d'accès aux données.
	 * 
	 * @see DAO
	 */
	protected DAO<?> dao;
	
	/**
	 * Constructeur du contrôleur abstrait de formulaire.
	 * 
	 * @param dao
	 * 			Objet d'accès aux données.
	 * @param qR
	 *          Observable recevant le résultat de la requête.
	 * 
	 * @see FormulaireAbstractControler#dao
	 * @see QueryResult
	 * @see AbstractControler#AbstractControler(fr.fablabmars.observer.Observable)
	 */
	public FormulaireAbstractControler(DAO<?> dao,QueryResult qR){
		super(qR);
		this.dao=dao;
	}
	
	/**
	 * Contrôle les données entrées dans le formulaire.
	 * 
	 * @param data
	 * 			Paramètres renseignés dans le formulaire.
	 */
	public abstract void control(T data);
	
}
