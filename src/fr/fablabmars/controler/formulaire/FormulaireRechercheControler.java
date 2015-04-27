package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.DAOFactory;
import fr.fablabmars.model.bdd.FindResult;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.model.bdd.UtilisateurDAO;

/**
 * Contrôleur dédié au formulaire de recherche.
 * 
 * @author Guillaume Perouffe
 */
public class FormulaireRechercheControler extends FormulaireAbstractControler<ArrayList<String>> {

	/**
	 * Constructeur du formulaire de recherche.
	 * 
	 * @param qR
	 * 			Observable dans lequel on enregistre le résultat de la recherche.
	 * 
	 * @see FormulaireAbstractControler#FormulaireAbstractControler(fr.fablabmars.model.bdd.DAO, QueryResult)
	 * @see QueryResult
	 */
	public FormulaireRechercheControler(QueryResult qR) {
		super(DAOFactory.getDAOUtilisateur(), qR);
	}
	
	/**
	 * Contrôle les données (nom, prénom) sur l'utilisateur recherché.
	 * 
	 * @param nomPrenom
	 * 			Arraylist contenant le nom et le prénom de l'utilisateur recherché.
	 */
	@Override
	public void control(ArrayList<String> nomPrenom) {
		if(this.dao instanceof UtilisateurDAO){
			UtilisateurDAO utilDao= (UtilisateurDAO)dao;
			
			ArrayList<Utilisateur> resultat = utilDao.findNomPrenom(nomPrenom);
			if(resultat != null&& resultat.size()!=0){
				((FindResult<ArrayList<Utilisateur>>)this.obs).success(resultat);
			}
			else{
				((QueryResult)this.obs).failure();
			}
		} 
	}
}