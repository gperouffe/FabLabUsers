package fr.fablabmars.vue;

import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

public abstract class ResultPane extends ControlledPane implements Observer{
	
	private static final long serialVersionUID = 5004767295086152835L;
	protected QueryResult<?> qR;
	
	public ResultPane(QueryResult<?> qR){
		super();
		this.qR=qR;
	}
	
	@Override
	public abstract void update(Observable obs);
	
}
