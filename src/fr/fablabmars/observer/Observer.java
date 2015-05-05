package fr.fablabmars.observer;

/**
 * Interface Observateur
 * <p>
 * Les objets rendus Observer peuvent �tre mis � jour lorsqu'il sont notifi�s par les Observables auxquels ils sont abonn�s.
 * </p>
 * 
 * @author Guillaume Perouffe
 * 
 * @see Observable
 *
 */
public interface Observer {
	
	/**
	 * Mise � jour de l'observateur
	 * 
	 * @param obs
	 * 			Observable responsable de la notification
	 */
	public void update(Observable obs);
}
