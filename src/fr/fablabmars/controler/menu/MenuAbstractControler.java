package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

public abstract class MenuAbstractControler {

	protected CardMenu cardMenu;
	
	public MenuAbstractControler(CardMenu model){
		this.cardMenu = model;
	}
	
	public CardMenu getModel(){
		return cardMenu;
	}
	
	public abstract void control(String bouton);
	
}
