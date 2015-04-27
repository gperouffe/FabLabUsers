package fr.fablabmars.vue;

import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Panneau de résultat abstrait
 * 
 * @author Guillaume Perouffe
 *
 */
public abstract class ResultPane extends ControlledPane implements Observer{
	
	private static final long serialVersionUID = 5004767295086152835L;
	
	/**
	 * @see QueryResult
	 */
	protected QueryResult qR;
	
	/**
	 * Constructeur du panneau de résultat abstrait
	 * 
	 * @param qR
	 * 			Indicateur de succès observable
	 * 
	 * @see QueryResult
	 */
	public ResultPane(QueryResult qR){
		super();
		this.qR=qR;
	}
	
	@Override
	public abstract void update(Observable obs);
	
}
