package fr.fablabmars.vue;

import java.awt.CardLayout;
import java.util.ArrayList;

import fr.fablabmars.controler.menu.MenuAbstractControler;
import fr.fablabmars.model.CardMenu;
import fr.fablabmars.model.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;

public class CardMenuPanel extends ControlledPane implements Observer {
	
	private static final long serialVersionUID = 2108235528799058080L;
	private ArrayList<String> listContent = new ArrayList<String>();
	private CardLayout cl;
	
	public CardMenuPanel(ArrayList<ControlledPane> panels, MenuAbstractControler controler){
		super();
		
		controler.getModel().addObserver(this);
		
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
			cl.show(this, listContent.get(((CardMenu)obs).getPanel()));
		}
	}
}
;