package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.QueryResult;
import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.dao.DAOFactory;
import fr.fablabmars.model.dao.UtilisateurDAO;

public class FormulaireUtilisateurControler extends FormulaireAbstractControler {
	
	public FormulaireUtilisateurControler(QueryResult qR){
		super(DAOFactory.getDAOUtilisateur(),qR);
	}

	@Override
	public void control(ArrayList list) {
		if(this.dao.create(new Utilisateur((String)list.get(0),(String)list.get(1),(String)list.get(2),(String)list.get(3),(String)list.get(4),(String)list.get(5),(Boolean)list.get(6)))){
			this.qR.success(null);
		}
		else{
			this.qR.failure();
		}
		
	}

}
