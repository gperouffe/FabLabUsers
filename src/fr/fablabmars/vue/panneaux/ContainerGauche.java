package fr.fablabmars.vue.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.fablabmars.vue.ControlledPane;

/**
 * Container du bandeau de menu gauche
 * 
 * @author Guillaume Perouffe
 *
 */
public class ContainerGauche extends ControlledPane{

	private static final long serialVersionUID = 4857027850134195913L;
	
	/**
	 * Constructeur du container gauche
	 */
	public ContainerGauche(){
		super();
		JPanel grid1;
		ButtonGroup groupe = new ButtonGroup();
		JToggleButton nvUser = new JToggleButton("Nouvel utilisateur");
		JToggleButton chercheContact = new JToggleButton("Chercher un utilisateur");
		groupe.add(nvUser);
		groupe.add(chercheContact);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		grid1 = new JPanel();
		grid1.setBackground(Color.WHITE);
		GridLayout gl = new GridLayout(0,1);
		gl.setVgap(10);
		grid1.setLayout(gl);
		grid1.add(nvUser);
		grid1.add(chercheContact);
		this.add(grid1,BorderLayout.NORTH);
		
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
}

