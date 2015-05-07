package fr.fablabmars.controler.menu;

import fr.fablabmars.controler.AbstractControler;
import fr.fablabmars.model.CardMenu;

/**
 * Contr�leur abstrait de menu.
 * 
 * @author Guillaume Perouffe
 *
 */
public abstract class MenuAbstractControler extends AbstractControler {
	
	/**
	 * Constructeur du contr�leur abstrait.
	 * 
	 * @param cardMenu
	 * 			Observable retenant le menu courant.
	 * 
	 * @see CardMenu
	 */
	public MenuAbstractControler(CardMenu cardMenu){
		super(cardMenu);
	}
	
	/**
	 * Change le menu courant.
	 * 	
	 * @param menu
	 *			Nom du nouveau menu courant.
	 */			
	public abstract void control(String menu);
	
}
