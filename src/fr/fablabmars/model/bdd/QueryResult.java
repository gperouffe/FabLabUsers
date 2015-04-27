package fr.fablabmars.model.bdd;

import java.util.ArrayList;

import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Modèle contenant le resultat d'une requête
 * 
 * @author Guillaume Perouffe
 *
 * @param <T>
 * 			Type des données reçues
 */
public class QueryResult<T> implements Observable {

	/**
	 * Liste des observateurs de ce modèle
	 */
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	/**
	 * Indicateur de succès de la requête
	 */
	private int success;
	
	/**
	 * Données reçues
	 */
	private T data;
	
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
	 * 			Observable à copier
	 */
	public QueryResult(QueryResult<T> QR){
		this.success= QR.success;
	}
	
	/**
	 * Indique que la requête est un succès et retient les données
	 * 
	 * @param data
	 * 			Données à retenir
	 */
	public void success(T data){
		success=1;
		this.data = data;
		notifyObservers();
	}
	
	/**
	 * Indique que la requête est un echec
	 */
	public void failure(){
		success=0;
		notifyObservers();
	}
	
	/**
	 * Retourne les dernières données reçues
	 * 
	 * @return Données reçues
	 * @see QueryResult#data
	 */
	public T getData(){
		return this.data;
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
	 * Indique si la dernière requête a été un succès
	 * 
	 * @return 1 si la dernière requête a été un succès, 0 sinon
	 */
	@Override
	public int getState() {
		return success;
	}
}
