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
	 * Constructeur du contrôleur abstrait de formulaire.
	 * 
	 * @param qR
	 *          Observable recevant le résultat de la requête.
	 * 
	 * @see QueryResult
	 * @see AbstractControler#AbstractControler(fr.fablabmars.observer.Observable)
	 */
	public FormulaireAbstractControler(QueryResult qR){
		super(qR);
	}
	
	/**
	 * Contrôle les données entrées dans le formulaire.
	 * 
	 * @param data
	 * 			Paramètres renseignés dans le formulaire.
	 */
	public abstract void control(T data);
	
}
