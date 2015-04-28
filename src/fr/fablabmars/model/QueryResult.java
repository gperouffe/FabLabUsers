package fr.fablabmars.model;


import java.util.ArrayList;

import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

public class QueryResult<T> implements Observable {

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	private Boolean success;
	private T data;
	
	public QueryResult(){
		this.success=false;
	}
	public QueryResult(QueryResult<T> QR){
		this.success=new Boolean(QR.success);
	}
	
	public void success(T data){
		success=true;
		this.data = data;
		notifyObservers();
	}
	
	public void failure(){
		success=false;
		notifyObservers();
	}
	
	public Boolean isSuccess(){
		return success;
	}
	
	public T getData(){
		return data;
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
