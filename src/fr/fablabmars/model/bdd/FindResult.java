package fr.fablabmars.model.bdd;

/**
 * Retient les données reçues après une requête, en plus d'indiquer son succès/echec
 * 
 * @author Guillaume Perouffe
 *
 * @param <T>
 * 			Type des données reçues
 */
public class FindResult<T> extends QueryResult {

	/**
	 * Données reçues
	 */
	private T data;
	
	/**
	 * Retourne les dernières données reçues
	 * 
	 * @return Données reçues
	 * @see FindResult#data
	 */
	public T getData(){
		return this.data;
	}
	
	/**
	 * Indique que la requête est un succès et retient les données
	 * 
	 * @param data
	 * 			Données à retenir
	 */
	public void success(T data){
		super.success();
		this.data=data;
		notifyObservers();
	}
}
