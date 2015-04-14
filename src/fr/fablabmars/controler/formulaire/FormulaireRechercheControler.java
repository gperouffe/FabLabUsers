package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.QueryResult;
import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.dao.DAOFactory;

public class FormulaireRechercheControler extends FormulaireAbstractControler {

	public FormulaireRechercheControler(QueryResult qR) {
		super(DAOFactory.getDAOUtilisateur(), qR);
	}

	@Override
	public void control(ArrayList<String> list) {
		ArrayList<Utilisateur> resultat = this.dao.find(list);
		if(resultat != null&& resultat.size()!=0){
			qR.success(resultat);
		}
		else{
			qR.failure();
		}
	}

}
