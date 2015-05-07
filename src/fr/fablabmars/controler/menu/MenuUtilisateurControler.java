package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

/**
 * Contrôleur du menu d'enregistrement d'un nouvel utilisateur.
 * 
 * @author Guillaume Perouffe
 *
 */
public class MenuUtilisateurControler extends MenuAbstractControler {
	
	/**
	 * Constructeur du menu d'enregistrement d'un nouvel utilisateur.
	 * 
	 * @param cardMenu
	 * 			Observable retenant le menu courant.
	 * 
	 * @see CardMenu
	 */
	public MenuUtilisateurControler(CardMenu cardMenu){
		super(cardMenu);
	}

	@Override
	public void control(String menu) {
		if(menu.contains("Succès")){
			((CardMenu)this.obs).setPanel(1);
		}
		else if(menu.contains("Echec")){
			((CardMenu)this.obs).setPanel(2);
		}
		else if(menu.contains("Retour")){
			((CardMenu)this.obs).setPanel(0);
		}
	}

}
