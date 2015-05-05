package fr.fablabmars.observer;

/**
 * Interface Observable
 * <p>
 * Les objets rendus Observables peuvent notifier tous leurs observateurs Observer.
 * </p>
 * 
 * @author Guillaume Perouffe
 *
 *@see Observer
 */
public interface Observable {
	
	/**
	 * Abonnement d'un observateur
	 * 
	 * @param obs
	 * 			Observateur � ajouter
	 * @see Observer
	 */
	public void addObserver(Observer obs);
	
	/**
	 * R�siliation d'un observateur
	 * 
	 * @param obs
	 * 			Observateur � retirer
	 * 
	 * @see Observer
	 */
	public void removeObserver(Observer obs);
	
	/**
	 * Notification des observateurs
	 */
	public void notifyObservers();
	
	/**
	 * Retourne l'�tat courant de l'observable
	 * 
	 * @returne Etat courant de l'observable
	 */
	public int getState();
	
}