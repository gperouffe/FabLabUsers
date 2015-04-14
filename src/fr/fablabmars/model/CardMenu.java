package fr.fablabmars.model;

import java.util.ArrayList;

import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

public class CardMenu implements Observable {

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	private int panel;
	
	public CardMenu(){
		panel = 0;
	}
	
	public int getPanel(){
		return panel;
	}
	
	public void setPanel(int i){
		panel = i; 
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
}
