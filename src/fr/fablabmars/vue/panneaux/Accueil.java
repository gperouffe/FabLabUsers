package fr.fablabmars.vue.panneaux;

import java.awt.Color;

import javax.swing.JLabel;

import fr.fablabmars.vue.ControlledPane;

public class Accueil extends ControlledPane{

	private static final long serialVersionUID = 978947793065234762L;

	public Accueil(){
		super();
		this.setBackground(Color.WHITE);
		this.add(new JLabel("<html>Bienvenue sur FablabUsers,<br>le logiciel de gestion du Fablab Marseille.</html>"));
	}
}