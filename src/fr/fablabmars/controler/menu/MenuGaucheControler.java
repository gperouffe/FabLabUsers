package fr.fablabmars.controler.menu;

import java.sql.Connection;

import fr.fablabmars.model.CardMenu;
import fr.fablabmars.model.dao.ConnectionFabLab;

public class MenuGaucheControler extends MenuAbstractControler{
	
	public MenuGaucheControler(CardMenu cardMenu){
		super(cardMenu);
	}
	
	@Override
	public void control(String bouton){
		if(bouton.contains("Nouvel utilisateur")){
			this.cardMenu.setPanel(1);
		}
		else if(bouton.contains("Chercher")){
			this.cardMenu.setPanel(2);
		}
	}

}
