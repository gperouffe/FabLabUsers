package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.DAOFactory;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.model.bdd.UtilisateurDAO;

/**
 * Contrôleur dédié au formulaire de recherche.
 * 
 * @author Guillaume Perouffe
 */
public class FormulaireRechercheControler extends FormulaireAbstractControler {

	/**
	 * Constructeur du formulaire de recherche.
	 * 
	 * @param qR
	 * 			Observable dans lequel on enregistre le résultat de la recherche.
	 * 
	 * @see FormulaireAbstractControler#FormulaireAbstractControler(fr.fablabmars.model.bdd.DAO, QueryResult)
	 * @see QueryResult
	 */
	public FormulaireRechercheControler(QueryResult<ArrayList<Utilisateur>> qR) {
		super(DAOFactory.getDAOUtilisateur(), qR);
	}
	
	/**
	 * Contrôle les données (nom, prénom) sur l'utilisateur recherché.
	 * 
	 * @param nomPrenom
	 * 			Arraylist contenant le nom et le prénom de l'utilisateur recherché.
	 */
	@Override
	public void control(ArrayList<?> nomPrenom) {
		if(this.dao instanceof UtilisateurDAO){
			ArrayList<String> nomPrenomStr = new ArrayList<String>();
			UtilisateurDAO utilDao= (UtilisateurDAO)dao;
			if(nomPrenom.get(0) instanceof String && nomPrenom.get(1) instanceof String){
				nomPrenomStr.add((String)nomPrenom.get(0));
				nomPrenomStr.add((String)nomPrenom.get(1));
				
			}
			
			ArrayList<Utilisateur> resultat = utilDao.findNomPrenom(nomPrenomStr);
			if(resultat != null&& resultat.size()!=0){
				((QueryResult<ArrayList<Utilisateur>>)this.obs).success(resultat);
			}
			else{
				((QueryResult<?>)this.obs).failure();
			}
		} 
	}
}