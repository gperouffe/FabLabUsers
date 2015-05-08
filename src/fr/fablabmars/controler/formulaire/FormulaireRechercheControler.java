package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.DAOFactory;
import fr.fablabmars.model.bdd.FindResult;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.model.bdd.UtilisateurDAO;

/**
 * Contr�leur d�di� au formulaire de recherche.
 * 
 * @author Guillaume Perouffe
 */
public class FormulaireRechercheControler extends FormulaireAbstractControler<ArrayList<String>> {

	/**
	 * Constructeur du formulaire de recherche.
	 * 
	 * @param fR
	 * 			Observable dans lequel on enregistre le r�sultat de la recherche.
	 * 
	 * @see FormulaireAbstractControler#FormulaireAbstractControler(fr.fablabmars.model.bdd.DAO, QueryResult)
	 * @see FindResult
	 */
	public FormulaireRechercheControler(FindResult<Utilisateur> fR) {
		super(fR);
	}
	
	/**
	 * Contr�le les donn�es (nom, pr�nom) sur l'utilisateur recherch�.
	 * 
	 * @param nomEmail
	 * 			Arraylist contenant le nom et le pr�nom de l'utilisateur recherch�.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void control(ArrayList<String> nomEmail) {
		UtilisateurDAO utilDao= DAOFactory.getDAOUtilisateur();
			
		Utilisateur resultat = utilDao.findNomEmail(nomEmail.get(0),nomEmail.get(1));
		if(resultat != null){
			((FindResult<Utilisateur>)this.obs).success(resultat);
		}
		else{
			((QueryResult)this.obs).failure();
		}
	}
}
