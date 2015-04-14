package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

public class MenuUtilisateurControler extends MenuAbstractControler {
	
	public MenuUtilisateurControler(CardMenu cardMenu){
		super(cardMenu);
	}

	@Override
	public void control(String menu) {
		if(menu.contains("Succès")){
			this.cardMenu.setPanel(1);
		}
		else if(menu.contains("Echec")){
			this.cardMenu.setPanel(2);
		}
		else if(menu.contains("Retour")){
			this.cardMenu.setPanel(0);
		}
	}

}
