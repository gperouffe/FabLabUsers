package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

/**
 * Contrôleur du menu gauche.
 * 
 * @author Guillaume Perouffe
 *
 */
public class MenuGaucheControler extends MenuAbstractControler{
	
	/**
	 * Constructeur du menu gauche.
	 * 
	 * @param cardMenu
	 * 			Observable retenant le menu courant.
	 * 
	 * @see CardMenu
	 */
	public MenuGaucheControler(CardMenu cardMenu){
		super(cardMenu);
	}
	
	@Override
	public void control(String bouton){
		if(bouton.contains("Nouvel utilisateur")){
			((CardMenu)this.obs).setPanel(1);
		}
		else if(bouton.contains("Chercher")){
			((CardMenu)this.obs).setPanel(2);
		}
	}

}
