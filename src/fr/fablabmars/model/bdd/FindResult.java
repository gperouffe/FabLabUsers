package fr.fablabmars.model.bdd;

/**
 * Retient les donn�es re�ues apr�s une requ�te, en plus d'indiquer son succ�s/echec
 * 
 * @author Guillaume Perouffe
 *
 * @param <T>
 * 			Type des donn�es re�ues
 */
public class FindResult<T> extends QueryResult {

	/**
	 * Donn�es re�ues
	 */
	private T data;
	
	/**
	 * Retourne les derni�res donn�es re�ues
	 * 
	 * @return Donn�es re�ues
	 * @see FindResult#data
	 */
	public T getData(){
		return this.data;
	}
	
	/**
	 * Indique que la requ�te est un succ�s et retient les donn�es
	 * 
	 * @param data
	 * 			Donn�es � retenir
	 */
	public void success(T data){
		super.success();
		this.data=data;
		notifyObservers();
	}
}
