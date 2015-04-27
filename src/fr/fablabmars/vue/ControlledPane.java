package fr.fablabmars.vue;

import javax.swing.JPanel;

import fr.fablabmars.controler.menu.MenuAbstractControler;

/**
 * Panneau pouvant être muni du contrôleur du menu auquel il appartient
 * 
 * @author Guillaume Perouffe
 *
 */
public class ControlledPane extends JPanel {
	
	private static final long serialVersionUID = 1598713790335211557L;
	
	/**
	 * Contrôleur de menu
	 * 
	 * @see MenuAbstractControler
	 */
	protected MenuAbstractControler controler=null;
	
	/**
	 * Définition du contrôleur
	 * 
	 * @param menuCont
	 * 			Contrôleur devant être rattaché à ce panneau
	 * 
	 * @see MenuAbstractControler
	 */
	public void setControler(MenuAbstractControler menuCont){
		this.controler=menuCont;
	}
	
}
