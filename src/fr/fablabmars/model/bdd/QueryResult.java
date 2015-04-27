package fr.fablabmars.model.bdd;

import java.util.ArrayList;

import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Indicateur de succ�s observable d'une requ�te
 * 
 * @author Guillaume Perouffe
 *
 */
public class QueryResult implements Observable {

	/**
	 * Liste des observateurs de ce mod�le
	 */
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	/**
	 * Indicateur de succ�s de la requ�te
	 */
	private int success;
	
	/**
	 * Constructeur de l'observable
	 */
	public QueryResult(){
		this.success=0;
	}
	
	/**
	 * Constructeur par copie
	 * 
	 * @param QR
	 * 			Observable � copier
	 */
	public QueryResult(QueryResult QR){
		this.success= QR.success;
	}
	
	/**
	 * Indique que la requ�te est un succ�s 
	 */
	public void success(){
		success=1;
		notifyObservers();
	}
	
	/**
	 * Indique que la requ�te est un echec
	 */
	public void failure(){
		success=0;
		notifyObservers();
	}
	
	@Override
	public void addObserver(Observer obs) {
		listObserver.add(obs);
	} 
	

	@Override
	public void removeObserver(Observer obs) {
		listObserver.remove(obs);
	}
	
	@Override
	public void notifyObservers() {
		for(Observer obs:listObserver){
			obs.update(this);
		}
	}

	/**
	 * Indique si la derni�re requ�te a �t� un succ�s
	 * 
	 * @return 1 si la derni�re requ�te a �t� un succ�s, 0 sinon
	 */
	@Override
	public int getState() {
		return success;
	}
}
