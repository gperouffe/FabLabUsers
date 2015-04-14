package fr.fablabmars.controler.formulaire;

import java.util.ArrayList;

import fr.fablabmars.model.QueryResult;
import fr.fablabmars.model.dao.DAO;


@SuppressWarnings("rawtypes")
public abstract class FormulaireAbstractControler {
	
	protected DAO dao;
	protected QueryResult qR;

	public FormulaireAbstractControler(DAO dao,QueryResult qR){
		this.dao=dao;
		this.qR=qR;
	}

	public DAO getModel(){
		return dao;
	}
	
	public abstract void control(ArrayList<String> list);
	
}
