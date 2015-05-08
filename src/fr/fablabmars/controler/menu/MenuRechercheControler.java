package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

/**
 * Contr�leur du menu de recherche.
 * 
 * @author Guillaume Perouffe
 *
 */
public class MenuRechercheControler extends MenuAbstractControler{
	
	/**
	 * Constructeur du menu de recherche.
	 * 
	 * @param MenuRecherche
	 *			Observable retenant le menu courant.
	 *
	 *@see CardMenu
	 */
	public MenuRechercheControler(CardMenu MenuRecherche){
		super(MenuRecherche);
	}

	@Override
	public void control(String menu) {
		if(menu.contains("Succ�s")){
			((CardMenu)this.obs).setPanel(1);		
		}
		else if(menu.contains("Echec")){
			((CardMenu)this.obs).setPanel(0);
		}
		else if(menu.contains("Facture")){
			((CardMenu)this.obs).setPanel(2);
		}
		else if(menu.contains("Cotisation")){
			((CardMenu)this.obs).setPanel(3);
		}
		else if(menu.contains("Modifier")){
			((CardMenu)this.obs).setPanel(4);
		}
		else if(menu.contains("Retour")){
			((CardMenu)this.obs).setPanel(0);
		}
	}

}