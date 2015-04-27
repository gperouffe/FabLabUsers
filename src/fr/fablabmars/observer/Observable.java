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
	 * 			Observateur à ajouter
	 * @see Observer
	 */
	public void addObserver(Observer obs);
	
	/**
	 * Résiliation d'un observateur
	 * 
	 * @param obs
	 * 			Observateur à retirer
	 * 
	 * @see Observer
	 */
	public void removeObserver(Observer obs);
	
	/**
	 * Notification des observateurs
	 */
	public void notifyObservers();
	
	/**
	 * Retourne l'état courant de l'observable
	 * 
	 * @returne Etat courant de l'observable
	 */
	public int getState();
	
}