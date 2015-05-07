package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.bdd.ConnectionFabLab;
import fr.fablabmars.model.bdd.QueryResult;

/**
 * Contrôleur dédié à la connexion BDD depuis la page d'acceuil.
 * 
 * @author Guillaume Perouffe
 */
public class FormulaireAcceuilControler extends FormulaireAbstractControler<ArrayList<String>> {

	/**
	 * Constructeur du contrôleur du formulaire de connexion.
	 * 
	 * @param
	 */
	public FormulaireAcceuilControler(QueryResult qR) {
		super(null, qR);
	}
	
	/**
	 * Contrôle les données (nom, prénom) sur l'utilisateur recherché.
	 * 
	 * @param nomPrenom
	 * 			Arraylist contenant le nom et le prénom de l'utilisateur recherché.
	 */
	@Override
	public void control(ArrayList<String> infosConn) {
		ConnectionFabLab.setUrl(infosConn.get(0));
		ConnectionFabLab.setUser(infosConn.get(1));
		ConnectionFabLab.setPasswd(infosConn.get(2));
		
		if(ConnectionFabLab.getInstance()==null){
			((QueryResult)this.obs).failure();
		}
		else{
			((QueryResult)this.obs).success();

		}
	}
}