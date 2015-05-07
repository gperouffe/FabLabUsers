package fr.fablabmars.vue;

import java.awt.CardLayout;
import java.util.ArrayList;

import fr.fablabmars.controler.menu.MenuAbstractControler;
import fr.fablabmars.model.CardMenu;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

/**
 * Regroupement de plusieurs panels organisés en CardLayout
 * <p>
 * Observe le model et met le panel correspondant au menu courant au premier plan.
 * </p>
 * @author Guillaume Perouffe
 *
 */
public class CardMenuPanel extends ControlledPane implements Observer {
	
	private static final long serialVersionUID = 2108235528799058080L;
	
	/**
	 * Liste des noms des panneaux
	 */
	private ArrayList<String> listContent = new ArrayList<String>();
	
	/**
	 * CardLayout du Panel
	 */
	private CardLayout cl;
	
	/**
	 * Constructeur de CardMenuPanel
	 * 
	 * @param panels
	 * 			Panneaux à ajouter dans le CardMenu
	 * @param controler
	 * 			Contrôleur du menu
	 * 
	 * @see ControlledPane
	 * @see MenuAbstractControler
	 */
	public CardMenuPanel(ArrayList<ControlledPane> panels, MenuAbstractControler controler){
		super();
		
		controler.getObservable().addObserver(this);
		
		cl = new CardLayout();
		this.setLayout(cl);
		for(int i=0;i<panels.size();i++){
			ControlledPane pan = panels.get(i);
			pan.setControler(controler);
			listContent.add(new String(""+i));
			this.add(pan, listContent.get(i));
		}
	}
	
	@Override
	public void update(Observable obs) {
		if(obs instanceof CardMenu){
			cl.show(this, listContent.get(((CardMenu)obs).getState()));
		}
	}
}
;