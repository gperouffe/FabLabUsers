package fr.fablabmars.vue;

import javax.swing.JPanel;

import fr.fablabmars.controler.menu.MenuAbstractControler;

public class ControlledPane extends JPanel {
	
	private static final long serialVersionUID = 1598713790335211557L;
	protected MenuAbstractControler controler=null;
	
	public ControlledPane(){
		super();
	}
	
	public void setControler(MenuAbstractControler menuCont){
		this.controler=menuCont;
	}
	
}
