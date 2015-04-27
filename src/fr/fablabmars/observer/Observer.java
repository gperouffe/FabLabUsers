package fr.fablabmars.observer;

/**
 * Interface Observateur
 * <p>
 * Les objets rendus Observer peuvent être mis à jour lorsqu'il sont notifiés par les Observables auxquels ils sont abonnés.
 * </p>
 * 
 * @author Guillaume Perouffe
 * 
 * @see Observable
 *
 */
public interface Observer {
	
	/**
	 * Mise à jour de l'observateur
	 * 
	 * @param obs
	 * 			Observable responsable de la notification
	 */
	public void update(Observable obs);
}
