package fr.fablabmars.vue.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fr.fablabmars.model.QueryResult;
import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.vue.ResultPane;

public class RechercheResultat extends ResultPane{

	private static final long serialVersionUID = -7767397382002106339L;
	private JLabel nomR = 			new JLabel("");
	private JLabel prenomR = 		new JLabel("");
	private JLabel adresseR = 		new JLabel("");
	private JLabel numeroTelR =	 	new JLabel("");
	private JLabel emailR = 		new JLabel("");
	private JLabel cotisant = 		new JLabel("");
	private JLabel pro = 			new JLabel("");
	private JLabel expiration = 	new JLabel("");
	private JLabel nbFacture =	 	new JLabel("");
	
	public RechercheResultat(QueryResult qR){
		super(qR);
		JLabel nomL = 			new JLabel("Nom");
		JLabel prenomL = 		new JLabel("Prénom");
		JLabel adresseL = 		new JLabel("Adresse");
		JLabel numeroTelL =	 	new JLabel("Numéro de telephone");
		JLabel emailL = 		new JLabel("Email");
		JLabel cotisantL = 		new JLabel("Cotisation");
		JLabel expirationL = 	new JLabel("Expire en ");
		JLabel proL = 			new JLabel("Professionnel");
		JLabel nbFactureL =	 	new JLabel("Nombre de factures");
		JButton facture = 		new JButton("Nouvelle facture");
		JButton cotiz = 		new JButton("Cotisation");
		JButton modifier = 		new JButton("Modifier les infos");
		JButton retour = 		new JButton("Retour");
		retour.addActionListener(new BoutonListener());
		
		JPanel grid1 = 			new JPanel();
		JPanel grid2 = 			new JPanel();
		JPanel grid3 = 			new JPanel();
		JPanel grid4 = 			new JPanel();
		JPanel grid5 = 			new JPanel();
		JPanel border = 		new JPanel();
		
		this.setBackground(Color.WHITE);
		GridLayout gl = new GridLayout(0,2);
		gl.setVgap(15);
		grid1.setLayout(gl);
		grid1.add(nomL);
		grid1.add(nomR);
		grid1.add(prenomL);
		grid1.add(prenomR);
		grid1.add(adresseL);
		grid1.add(adresseR);
		grid1.add(numeroTelL);
		grid1.add(numeroTelR);
		grid1.add(emailL);
		grid1.add(emailR);
		grid1.setBackground(Color.WHITE);
		GridLayout gl2 = new GridLayout(0,2);
		gl2.setVgap(15);
		grid2.setLayout(gl2);
		grid2.setBackground(Color.WHITE);
		grid2.add(cotisantL);
		grid2.add(cotisant);
		grid2.add(expirationL);
		grid2.add(expiration);
		grid2.add(proL);
		grid2.add(pro);
		grid2.add(nbFactureL);
		grid2.add(nbFacture);
		GridLayout gl3 = new GridLayout(1,0);
		gl3.setHgap(15);
		grid3.setLayout(gl3);
		grid3.add(grid1);
		grid3.add(grid2);
		grid3.setBackground(Color.WHITE);
		GridLayout gl4 = new GridLayout(1,0);
		gl4.setHgap(15);
		grid4.setBackground(Color.WHITE);
		grid4.setLayout(gl4);
		grid4.add(facture);
		grid4.add(cotiz);
		grid4.add(modifier);
		grid4.add(retour);
		border.setLayout(new BorderLayout());
		border.setBackground(Color.WHITE);
		border.add(grid4, BorderLayout.NORTH);
		grid5.setLayout(new GridLayout(0,1));
		grid5.add(grid3);
		grid5.add(border);
		grid5.setBackground(Color.WHITE);
		

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Resultat de la recherche");
		grid3.setBorder(title);
		
		this.add(grid5);
		qR.addObserver(this);
			
	}


	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			controler.control(((JButton)e.getSource()).getText());
		}
	}


	@Override
	public void update(Observable obs) {
		if(obs instanceof QueryResult){
			if(((ArrayList<Utilisateur>)(((QueryResult)obs).getData())).size()==1){
				Utilisateur util = new Utilisateur(((ArrayList<Utilisateur>)(((QueryResult)obs).getData())).get(0));
				nomR.setText(util.getNom());
				prenomR.setText(util.getPrenom());
				adresseR.setText(util.getAdresse());
				numeroTelR.setText(util.getNumero());
				emailR.setText(util.getEmail());
				cotisant.setText(util.isCotisant()?"Oui":"Non");
				pro.setText(util.isPro()?"Oui":"Non");
				expiration.setText("");
				nbFacture.setText("");
			}
		}
	}
}