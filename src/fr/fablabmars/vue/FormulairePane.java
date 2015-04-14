package fr.fablabmars.vue;

import fr.fablabmars.model.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

public abstract class FormulairePane extends ControlledPane implements Observer{
	
	private static final long serialVersionUID = 5004767295086152835L;
	protected QueryResult qR;
	
	public FormulairePane(QueryResult qR){
		super();
		this.qR=qR;
		this.initFormControler();
	}
	
	protected abstract void initFormControler();
	
	@Override
	public abstract void update(Observable obs);
	
}
