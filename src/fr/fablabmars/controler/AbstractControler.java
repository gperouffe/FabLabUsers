package fr.fablabmars.controler;

import fr.fablabmars.observer.Observable;

/**
 * Contrôleur abstrait.
 * 
 * @author Guillaume Perouffe
 *
 */
public abstract class AbstractControler {
	
	/**
	 * Observable recevant le résultat du contrôle
	 * 
	 * @see Observable
	 */
	protected Observable obs;
	
	/**
	 * Constructeur du contrôleur abstrait.
	 * 
	 * @param obs
	 * 			Observable recevant le résultat du contrôle
	 * 
	 * @see AbstractControler#obs
	 */
	public AbstractControler(Observable obs){
		this.obs=obs;
	}
	
	/**
	 * Retourne l'observable lié au contrôleur.
	 * 
	 * @return Observable lié au contrôleur.
	 */
	public Observable getObservable(){
		return this.obs;
	}
	
		
}
