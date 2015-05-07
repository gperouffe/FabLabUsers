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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import fr.fablabmars.controler.formulaire.FormulaireAcceuilControler;
import fr.fablabmars.model.bdd.ConnectionFabLab;
import fr.fablabmars.model.bdd.QueryResult;
import fr.fablabmars.observer.Observable;
import fr.fablabmars.vue.FormulairePane;

/**
 * Panneau d'accueil
 * 
 * @author Guillaume Perouffe
 *
 */
public class Accueil extends FormulairePane{

	private static final long serialVersionUID = 978947793065234762L;
	private JTextField serv 	=	new JTextField(ConnectionFabLab.getUrl());
	private JTextField login 	=	new JTextField(ConnectionFabLab.getUser());
	private JPasswordField password = 	new JPasswordField("");
	private JLabel connectState =	new JLabel("Non connecté");
	private FormulaireAcceuilControler fac;
	
	/**
	 * Constructeur du formulaire d'acceuil
	 */
	public Accueil(QueryResult qR){
		super(qR);
		qR.addObserver(this);
		fac = new FormulaireAcceuilControler(qR);

		JButton connect = 	new JButton("Connexion");
		JButton disconnect = 	new JButton("Déconnexion");
		JLabel servL = 			new JLabel("Serveur");
		JLabel loginL = 		new JLabel("Login");
		JLabel passwordL = 		new JLabel("Mot de Passe                              ");
		JPanel grid1 = 			new JPanel();
		JPanel grid2 = 			new JPanel();
		JPanel grid3 = 			new JPanel();
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
		JLabel phraseAcceuil = new JLabel("<html>Bienvenue sur FablabUsers,<br>le logiciel de gestion du Fablab Marseille.</html>");
		phraseAcceuil.setHorizontalAlignment(JLabel.CENTER);
		phraseAcceuil.setVerticalAlignment(JLabel.CENTER);
		grid1.add(phraseAcceuil);

		
		GridLayout gl2 = new GridLayout(0,2);
		gl2.setVgap(15);
		grid2.setLayout(gl2);
		grid2.add(servL);
		grid2.add(serv);
		grid2.add(loginL);
		grid2.add(login);
		grid2.add(passwordL);
		grid2.add(password);
		grid2.setBackground(Color.WHITE);
		grid1.add(grid2);
		grid1.setBackground(Color.WHITE);
		
		GridLayout gl3 = new GridLayout(0,2);
		gl3.setVgap(15);
		grid3.setLayout(gl3);
		grid3.add(connect);
		connectState.setHorizontalAlignment(JLabel.CENTER);
		connectState.setVerticalAlignment(JLabel.CENTER);
		grid3.add(connectState);
		grid3.add(disconnect);
		grid3.setBackground(Color.WHITE);
		border1.add(grid3, BorderLayout.NORTH);
		connect.addActionListener(new ConnectListener());
		disconnect.addActionListener(new DisconnectListener());
		border1.setBackground(Color.WHITE);
		grid1.add(border1);
		border2.add(grid1, BorderLayout.NORTH);
		border3.add(border2, BorderLayout.EAST);
		

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Connexion BDD");
		grid2.setBorder(title);
		
		this.add(border3);	
	}
	

	class ConnectListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> infosConn = new ArrayList<String>();
			
			infosConn.add(serv.getText());
			infosConn.add(login.getText());
			String input = new String(password.getPassword());
			infosConn.add(input);
			
			fac.control(infosConn);
			
			
		}
	}
	
	class DisconnectListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			fac.control(null);
		}
	}
	
	@Override
	public void update(Observable obs) {
		if(obs == qR){
			if(qR.getState()==0){
				connectState.setText("Non connecté");
			}
			else if(qR.getState()==1){
				connectState.setText("Connexion établie");
				password.setText("");
			}
		}
	}
}
