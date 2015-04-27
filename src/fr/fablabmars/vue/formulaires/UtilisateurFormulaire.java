package fr.fablabmars.vue.formulaires;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fr.fablabmars.controler.formulaire.FormulaireUtilisateurControler;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.vue.FormulairePane;

public class UtilisateurFormulaire extends FormulairePane{

	private static final long serialVersionUID = -7371992746415671076L;
	private JTextField nom = 		new JTextField("");
	private JTextField prenom = 	new JTextField("");
	private JTextField etab = 		new JTextField("");
	private JTextField adresse = 	new JTextField("");
	private JTextField codePostal = new JTextField("");
	private JTextField ville = 		new JTextField("");
	private JTextField numeroTel = 	new JTextField("");
	private JTextField email = 		new JTextField("");
	private JRadioButton proRB	=	new JRadioButton("Professionnel");
	private JRadioButton partRB	=	new JRadioButton("Particulier");
	private FormulaireUtilisateurControler fac;
	
	public UtilisateurFormulaire(QueryResult<?> qR){
		super(qR);
		qR.addObserver(this);
		this.fac = new FormulaireUtilisateurControler(qR);
		
		JButton enregistrer = 	new JButton("Enregistrer");
		enregistrer.addActionListener(new BoutonListener());
		JLabel nomL = 			new JLabel("Nom");
		JLabel prenomL = 		new JLabel("Prénom");
		JLabel etabL = 			new JLabel("Etablissement/Société");
		JLabel adresseL = 		new JLabel("Adresse");
		adresse.setEnabled(false);
		JLabel codePostalL = 	new JLabel("Code Postal");
		JLabel villeL = 		new JLabel("Ville");
		JLabel numeroTelL =	 	new JLabel("Numéro de telephone          ");
		JLabel emailL = 		new JLabel("Email");
		ButtonGroup groupe = 	new ButtonGroup();
		groupe.add(proRB);
		groupe.add(partRB);
		
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
		grid2.add(etabL);
		grid2.add(etab);
		grid2.add(adresseL);
		grid2.add(adresse);
		grid2.add(codePostalL);
		grid2.add(codePostal);
		grid2.add(villeL);
		grid2.add(ville);
		grid2.add(numeroTelL);
		grid2.add(numeroTel);
		grid2.add(emailL);
		grid2.add(email);
		partRB.setBackground(Color.WHITE);
		partRB.setSelected(true);
		grid2.add(partRB);
		proRB.setBackground(Color.WHITE);
		grid2.add(proRB);
		grid2.setBackground(Color.WHITE);
		grid1.add(grid2);
		grid1.setBackground(Color.WHITE);
		border1.add(enregistrer, BorderLayout.NORTH);
		border1.setBackground(Color.WHITE);
		grid1.add(border1);
		border2.add(grid1, BorderLayout.NORTH);
		border3.add(border2, BorderLayout.EAST);

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Coordonnées utilisateur");
		grid2.setBorder(title);
		
		this.add(border3);
		
	}

	class BoutonListener implements ActionListener{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void actionPerformed(ActionEvent e) {
			ArrayList list = new ArrayList();
			list.add(nom.getText());
			list.add(prenom.getText());
			list.add(etab.getText());
			list.add("<html>"+ adresse.getText()+"<br>"+ codePostal.getText()+" "+ville.getText()+"</html>");
			list.add(numeroTel.getText());
			list.add(email.getText());
			list.add(proRB.isSelected());
			fac.control(list);
		}
	}

	@Override
	public void update(Observable obs) {
		if(obs instanceof QueryResult){
			controler.control(((QueryResult<?>)obs).getState()==1?"Succès":"Echec");
		}
	}
	
	
	
}
