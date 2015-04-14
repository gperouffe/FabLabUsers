package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

public class MenuRechercheControler extends MenuAbstractControler{
		
	public MenuRechercheControler(CardMenu MenuRecherche){
		super(MenuRecherche);
	}

	@Override
	public void control(String bouton) {
		if(bouton.contains("Succès")){
			this.cardMenu.setPanel(1);
		}
		else if(bouton.contains("Echec")){
			this.cardMenu.setPanel(0);
		}
		else if(bouton.contains("Facture")){
			this.cardMenu.setPanel(2);
		}
		else if(bouton.contains("Cotisation")){
			this.cardMenu.setPanel(3);
		}
		else if(bouton.contains("Modifier")){
			this.cardMenu.setPanel(4);
		}
		else if(bouton.contains("Retour")){
			this.cardMenu.setPanel(0);
		}
	}

}