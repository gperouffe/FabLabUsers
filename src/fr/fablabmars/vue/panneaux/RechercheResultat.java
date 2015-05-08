package fr.fablabmars.vue.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fr.fablabmars.model.Utilisateur;
import fr.fablabmars.model.bdd.FindResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.vue.ResultPane;

/**
 * Panneau d'affichage du résultat de la recherche
 * 
 * @author Guillaume Perouffe
 *
 */
public class RechercheResultat extends ResultPane{

	private static final long serialVersionUID = -7767397382002106339L;
	private JLabel nomR = 			new JLabel("");
	private JLabel prenomR = 		new JLabel("");
	private JLabel etabR = 		new JLabel("");
	private JLabel adresseR = 		new JLabel("");
	private JLabel numeroTelR =	 	new JLabel("");
	private JLabel emailR = 		new JLabel("");
	private JLabel cotisant = 		new JLabel("");
	private JLabel pro = 			new JLabel("");
	private JLabel expiration = 	new JLabel("");
	private JLabel nbFacture =	 	new JLabel("");
	
	/**
	 * Constructeur du panneau de résultats
	 * 
	 * @param fR
	 * 			Indicateur de succès observable des requêtes
	 */
	public RechercheResultat(FindResult<Utilisateur> fR){
		super(fR);
		JLabel nomL = 			new JLabel("Nom");
		JLabel prenomL = 		new JLabel("Prénom");
		JLabel etabL = 		new JLabel("Etablissement");
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
		JPanel grid6 = 			new JPanel();
		JPanel grid7 = 			new JPanel();
		JPanel border1 = 		new JPanel();
		JPanel border2 = 		new JPanel();
		
		this.setBackground(Color.WHITE);
		GridLayout gl = new GridLayout(0,1);
		gl.setVgap(15);
		grid1.setBackground(Color.WHITE);
		grid1.setLayout(gl);
		grid2.setBackground(Color.WHITE);
		grid2.setLayout(gl);
		grid3.setBackground(Color.WHITE);
		grid3.setLayout(gl);
		grid4.setBackground(Color.WHITE);
		grid4.setLayout(gl);
		
		
		grid1.add(nomL);
		grid2.add(nomR);
		grid1.add(prenomL);
		grid2.add(prenomR);
		grid1.add(etabL);
		grid2.add(etabR);
		grid1.add(adresseL);
		grid2.add(adresseR);
		grid1.add(numeroTelL);
		grid2.add(numeroTelR);
		grid1.add(emailL);
		grid2.add(emailR);
		grid3.add(cotisantL);
		grid4.add(cotisant);
		grid3.add(expirationL);
		grid4.add(expiration);
		grid3.add(proL);
		grid4.add(pro);
		grid3.add(nbFactureL);
		grid4.add(nbFacture);
		
		GridLayout gl5 = new GridLayout(1,0);
		gl5.setHgap(15);
		grid5.setBackground(Color.WHITE);
		grid5.setLayout(new BoxLayout(grid5,BoxLayout.LINE_AXIS));
		grid5.add(grid1);
		grid5.add(grid2);
		grid5.add(grid3);
		grid5.add(grid4);
		
		GridLayout gl6 = new GridLayout(1,0);
		gl6.setHgap(15);
		grid6.setBackground(Color.WHITE);
		grid6.setLayout(gl6);
		grid6.add(facture);
		grid6.add(cotiz);
		grid6.add(modifier);
		grid6.add(retour);
		

		border1.setLayout(new BorderLayout());
		border1.setBackground(Color.WHITE);
		border1.add(grid5, BorderLayout.NORTH);
		border2.setLayout(new BorderLayout());
		border2.setBackground(Color.WHITE);
		border2.add(grid6, BorderLayout.NORTH);
		grid7.setLayout(new GridLayout(0,1));
		grid7.add(border1);
		grid7.add(border2);
		grid7.setBackground(Color.WHITE);
		

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Resultat de la recherche");
		grid5.setBorder(title);
		
		this.add(grid7);
	}

	/**
	 * Action Listener des boutons liés à un résultat de recherche
	 * 
	 * @author Guillaume Perouffe
	 *
	 */
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			controler.control(((JButton)e.getSource()).getText());
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable obs) {
		if(obs == qR){
			try{
				if((((FindResult<Utilisateur>)qR).getData())!=null){
					Utilisateur util = (((((FindResult<Utilisateur>)qR).getData())));
					nomR.setText(util.getNom());
					prenomR.setText(util.getPrenom());
					etabR.setText(util.getEtab());
					adresseR.setText(util.getAdresse());
					numeroTelR.setText(util.getNumero());
					emailR.setText(util.getEmail());
					cotisant.setText(util.isCotisant()?"Oui":"Non");
					pro.setText(util.isPro()?"Oui":"Non");
					expiration.setText("");
					nbFacture.setText("");
				}
					
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}
		}
	}
}
