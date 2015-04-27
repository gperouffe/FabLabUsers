package fr.fablabmars.vue;

import javax.swing.JPanel;

import fr.fablabmars.controler.menu.MenuAbstractControler;

/**
 * Panneau pouvant �tre muni du contr�leur du menu auquel il appartient
 * 
 * @author Guillaume Perouffe
 *
 */
public class ControlledPane extends JPanel {
	
	private static final long serialVersionUID = 1598713790335211557L;
	
	/**
	 * Contr�leur de menu
	 * 
	 * @see MenuAbstractControler
	 */
	protected MenuAbstractControler controler=null;
	
	/**
	 * D�finition du contr�leur
	 * 
	 * @param menuCont
	 * 			Contr�leur devant �tre rattach� � ce panneau
	 * 
	 * @see MenuAbstractControler
	 */
	public void setControler(MenuAbstractControler menuCont){
		this.controler=menuCont;
	}
	
}
