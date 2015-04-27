package fr.fablabmars.controler;

import fr.fablabmars.observer.Observable;

/**
 * Contr�leur abstrait.
 * 
 * @author Guillaume Perouffe
 *
 */
public abstract class AbstractControler {
	
	/**
	 * Observable recevant le r�sultat du contr�le
	 * 
	 * @see Observable
	 */
	protected Observable obs;
	
	/**
	 * Constructeur du contr�leur abstrait.
	 * 
	 * @param obs
	 * 			Observable recevant le r�sultat du contr�le
	 * 
	 * @see AbstractControler#obs
	 */
	public AbstractControler(Observable obs){
		this.obs=obs;
	}
	
	/**
	 * Retourne l'observable li� au contr�leur.
	 * 
	 * @return Observable li� au contr�leur.
	 */
	public Observable getObservable(){
		return this.obs;
	}
	
		
}
