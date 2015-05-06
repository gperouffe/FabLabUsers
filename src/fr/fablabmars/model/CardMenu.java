package fr.fablabmars.model;

import java.util.ArrayList;

import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Observable contenant le menu courant.
 * 
 * @author Guillaume Perouffe
 * @see Observable
 */
public class CardMenu implements Observable {

	/**
	 * Liste des observateurs de cet observable.
	 */
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	/**
	 * Indice du menu courant
	 */
	private int panel;
	
	/**
	 * Constructeur de l'observable
	 * <p>
	 * On initialise le menu sur le 'panel' par défaut,
	 * d'indice 0.
	 * </p>
	 * 
	 * @see CardMenu#panel
	 */
	public CardMenu(){
		panel = 0;
	}
	
	/**
	 *  Change le panneau courant et notifie les observateurs.
	 * 
	 * @param panel
	 * 			Indice du nouveau menu.
	 *			
	 * @see CardMenu#panel
	 * @see Observable#notifyObservers()
	 */
	public void setPanel(int panel){
		this.panel = panel; 
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
	 * Retourne le menu courant
	 * 
	 * @return Menu courant
	 * 
	 * @see CardMenu#panel
	 */
	@Override
	public int getState(){
		return panel;
	}

}
