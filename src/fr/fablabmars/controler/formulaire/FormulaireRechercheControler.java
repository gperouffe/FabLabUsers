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
	 * @see QueryResult
	 */
	public FormulaireRechercheControler(FindResult<ArrayList<Utilisateur>> fR) {
		super(DAOFactory.getDAOUtilisateur(), fR);
	}
	
	/**
	 * Contr�le les donn�es (nom, pr�nom) sur l'utilisateur recherch�.
	 * 
	 * @param nomPrenom
	 * 			Arraylist contenant le nom et le pr�nom de l'utilisateur recherch�.
	 */
	@SuppressWarnings("unchecked")
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