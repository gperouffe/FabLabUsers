package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.DAOFactory;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.model.bdd.UtilisateurDAO;

/**
 * Formulaire d'enregistement d'un nouvel Utilisateur.
 * 
 * @author Guillaume Perouffe
 *
 */
public class FormulaireUtilisateurControler extends FormulaireAbstractControler<ArrayList<?>> {
	
	/**
	 * Constructeur du formulaire d'enregistrement de l'utilisateur.
	 * 
	 * @param qR
	 * 			Observable dans lequel on indique le résultat de l'enregistement.
	 *
	 *@see QueryResult
	 */
	
	public FormulaireUtilisateurControler(QueryResult qR){
		super(qR);
	}

	/**
	 * Contrôle les données à enregistrer pour l'utilisateur.
	 * 
	 * @param list
	 * 			Liste des paramètres utilisateur à enregistrer.
	 */
	@Override
	public void control(ArrayList<?> list) {
		
		UtilisateurDAO utilDao= DAOFactory.getDAOUtilisateur();
		if(utilDao.create(new Utilisateur((String)list.get(0),(String)list.get(1),(String)list.get(2),(String)list.get(3),(String)list.get(4),(String)list.get(5),(Boolean)list.get(6)))){
			((QueryResult)this.obs).success();
		}
		else{
			((QueryResult)this.obs).failure();
		}
	}
}

