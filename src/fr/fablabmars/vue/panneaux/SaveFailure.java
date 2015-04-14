package fr.fablabmars.vue.panneaux;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.fablabmars.vue.ControlledPane;
import fr.fablabmars.vue.panneaux.SaveSuccess.BoutonListener;

public class SaveFailure extends ControlledPane{

	private static final long serialVersionUID = 978947793065234762L;

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
		grid.add(new JLabel("<html>L'enregistrement a �chou�.</html>"));
		grid.add(retour);
		this.add(grid);
	}
	
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			controler.control(((JButton)e.getSource()).getText());
		}
	}
}
