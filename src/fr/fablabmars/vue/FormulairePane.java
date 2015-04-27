package fr.fablabmars.vue;

import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Panneau de formulaire abstrait
 * 
 * @author Guillaume Perouffe
 *
 */
public abstract class FormulairePane extends ControlledPane implements Observer{
	
	private static final long serialVersionUID = 5004767295086152835L;
	
	/**
	 * Observable cible pour enregistrer le résultat de la requête
	 */
	protected QueryResult<?> qR;
	
	/**
	 * Constructeur du panneau de formulaire abstrait
	 * @param qR
	 */
	public FormulairePane(QueryResult<?> qR){
		super();
		this.qR=qR;
		//this.initFormControler();
	}
	
	//protected abstract void initFormControler();
	
	@Override
	public abstract void update(Observable obs);
	
}
