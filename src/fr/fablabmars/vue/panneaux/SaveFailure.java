package fr.fablabmars.vue.panneaux;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.fablabmars.vue.ControlledPane;

/**
 * Panneau d'information sur l'echec de l'enregistrement
 * 
 * @author Guillaume Perouffe
 *
 */
public class SaveFailure extends ControlledPane{

	private static final long serialVersionUID = 978947793065234762L;

	/**
	 * Constructeur du panneau Echec d'enregistrement
	 */
	public SaveFailure(){
		super();
		JPanel grid = new JPanel();
		JButton retour = new JButton("Retour");
		retour.addActionListener(new BoutonListener());
		this.setBackground(Color.WHITE);
		grid.setBackground(Color.WHITE);
		GridLayout gl = new GridLayout(0,1);
		gl.setVgap(15);
		grid.setLayout(gl);
		grid.add(new JLabel("<html>L'enregistrement a échoué.</html>"));
		grid.add(retour);
		this.add(grid);
	}
	
	/**
	 * Action Listener pour le bouton retour
	 * 
	 * @author Guillaume Perouffe
	 *
	 */
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			controler.control(((JButton)e.getSource()).getText());
		}
	}
}
