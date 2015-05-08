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
	 * Constructeur du contr�leur abstrait de formulaire.
	 * 
	 * @param qR
	 *          Observable recevant le r�sultat de la requ�te.
	 * 
	 * @see QueryResult
	 * @see AbstractControler#AbstractControler(fr.fablabmars.observer.Observable)
	 */
	public FormulaireAbstractControler(QueryResult qR){
		super(qR);
	}
	
	/**
	 * Contr�le les donn�es entr�es dans le formulaire.
	 * 
	 * @param data
	 * 			Param�tres renseign�s dans le formulaire.
	 */
	public abstract void control(T data);
	
}
