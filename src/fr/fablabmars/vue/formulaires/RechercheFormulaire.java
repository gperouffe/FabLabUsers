
package fr.fablabmars.vue.formulaires;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fr.fablabmars.controler.formulaire.FormulaireRechercheControler;
import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.FindResult;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.vue.FormulairePane;

/**
 * Formulaire de recherche d'un utilisateur
 * 
 * @author Guillaume Perouffe
 *
 */
public class RechercheFormulaire extends FormulairePane{

	private static final long serialVersionUID = -3341160299724135201L;
	private JTextField nom = 		new JTextField("");
	private JTextField prenom = 	new JTextField("");
	/**
	 * 
	 */
	private FormulaireRechercheControler fac;
	
	/**
	 * Constructeur du formulaire de recherche
	 * 
	 * @param fR
	 * 			Indicateur de succès observable
	 */
	public RechercheFormulaire(FindResult<ArrayList<Utilisateur>> fR){
		super(fR);
		fR.addObserver(this);
		this.fac = new FormulaireRechercheControler(fR);
		
		JButton recherche = 	new JButton("Recherche");
		JLabel nomL = 			new JLabel("Nom");
		JLabel prenomL = 		new JLabel("Prénom                                   ");
		JPanel grid1 = 			new JPanel();
		JPanel grid2 = 			new JPanel();
		JPanel border1 = 		new JPanel();	
		JPanel border2 = 		new JPanel();
		JPanel border3 = 		new JPanel();

		this.setBackground(Color.WHITE);
		this.setLayout(new FlowLayout());
		border1.setLayout(new BorderLayout());
		border2.setLayout(new BorderLayout());
		border3.setLayout(new BorderLayout());
		GridLayout gl1 = new GridLayout(0,1);
		gl1.setVgap(15);
		grid1.setLayout(gl1);
		GridLayout gl2 = new GridLayout(0,2);
		gl2.setVgap(15);
		grid2.setLayout(gl2);
		grid2.add(nomL);
		grid2.add(nom);
		grid2.add(prenomL);
		grid2.add(prenom);
		grid2.setBackground(Color.WHITE);
		grid1.add(grid2);
		grid1.setBackground(Color.WHITE);
		border1.add(recherche, BorderLayout.NORTH);
		recherche.addActionListener(new BoutonListener());
		border1.setBackground(Color.WHITE);
		grid1.add(border1);
		border2.add(grid1, BorderLayout.NORTH);
		border3.add(border2, BorderLayout.EAST);
		

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Rechercher l'utilisateur");
		grid2.setBorder(title);
		
		this.add(border3);
	}
	
	/**
	 * Action Listener du bouton de recherche
	 * 
	 * @author Guillaume Perouffe
	 *
	 */
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> nomPrenom = new ArrayList<String>();
			
			nomPrenom.add(nom.getText());
			nomPrenom.add(prenom.getText());
			
			fac.control(nomPrenom);
		}
	}
	
	@Override
	public void update(Observable obs) {
		controler.control(((QueryResult)obs).getState()==1?"Succès":"Echec");		
	}

}
