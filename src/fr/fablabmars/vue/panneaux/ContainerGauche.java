package fr.fablabmars.vue.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.observer.Observer;
import fr.fablabmars.vue.ControlledPane;

/**
 * Container du bandeau de menu gauche
 * 
 * @author Guillaume Perouffe
 *
 */
public class ContainerGauche extends ControlledPane implements Observer{

	private static final long serialVersionUID = 4857027850134195913L;
	private JToggleButton nvUser = new JToggleButton("Nouvel utilisateur");
	private JToggleButton chercheContact = new JToggleButton("Chercher un utilisateur");
	
	/**
	 * Constructeur du container gauche
	 */
	public ContainerGauche(QueryResult etatConn){
		super();
		etatConn.addObserver(this);
		JPanel grid1;
		ButtonGroup groupe = new ButtonGroup();
		JToggleButton acc = new JToggleButton("Accueil");
		groupe.add(acc);
		groupe.add(nvUser);
		groupe.add(chercheContact);
		nvUser.setEnabled(false);
		chercheContact.setEnabled(false);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		grid1 = new JPanel();
		grid1.setBackground(Color.WHITE);
		GridLayout gl = new GridLayout(0,1);
		gl.setVgap(10);
		grid1.setLayout(gl);
		grid1.add(acc);
		grid1.add(nvUser);
		grid1.add(chercheContact);
		this.add(grid1,BorderLayout.NORTH);
		
		acc.addActionListener(new BoutonListener());
		nvUser.addActionListener(new BoutonListener());
		chercheContact.addActionListener(new BoutonListener());
	}
	
	/**
	 * Contrôleur des boutons du bandeau de menu gauche
	 * 
	 * @author Guillaume Perouffe
	 *
	 */
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			controler.control(((JToggleButton)e.getSource()).getText());
		}
	}

	@Override
	public void update(Observable obs) {
		if(obs instanceof QueryResult){
			if(((QueryResult)obs).getState()==1){
				nvUser.setEnabled(true);
				chercheContact.setEnabled(true);
			}
			if(((QueryResult)obs).getState()==0){
				nvUser.setEnabled(false);
				chercheContact.setEnabled(false);
			}
		}
	}
}

