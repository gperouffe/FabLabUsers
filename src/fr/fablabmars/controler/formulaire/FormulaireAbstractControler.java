package fr.fablabmars.controler.formulaire;

import fr.fablabmars.controler.AbstractControler;
import fr.fablabmars.model.bdd.DAO;
import fr.fablabmars.model.bdd.QueryResult;

/**
 * Classe abstraite repr�sentant un controleur de formulaire
 * 
 * @author Guillaume Perouffe
 * @see AbstractControler
 * @param T
 * 			Type des donn�es re�ues depuis la vue
 */
public abstract class FormulaireAbstractControler<T> extends AbstractControler {
	
	/**
	 * Objet d'acc�s aux donn�es.
	 * 
	 * @see DAO
	 */
	protected DAO<?> dao;
	
	/**
	 * Constructeur du contr�leur abstrait de formulaire.
	 * 
	 * @param dao
	 * 			Objet d'acc�s aux donn�es.
	 * @param qR
	 *          Observable recevant le r�sultat de la requ�te.
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
	 * Contr�le les donn�es entr�es dans le formulaire.
	 * 
	 * @param data
	 * 			Param�tres renseign�s dans le formulaire.
	 */
	public abstract void control(T data);
	
}
