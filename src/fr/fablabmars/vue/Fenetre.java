package fr.fablabmars.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.fablabmars.controler.menu.MenuGaucheControler;
import fr.fablabmars.controler.menu.MenuRechercheControler;
import fr.fablabmars.controler.menu.MenuUtilisateurControler;
import fr.fablabmars.model.CardMenu;
import fr.fablabmars.model.QueryResult;
import fr.fablabmars.vue.formulaire.RechercheFormulaire;
import fr.fablabmars.vue.formulaire.UtilisateurFormulaire;
import fr.fablabmars.vue.panneaux.Accueil;
import fr.fablabmars.vue.panneaux.ContainerGauche;
import fr.fablabmars.vue.panneaux.Entete;
import fr.fablabmars.vue.panneaux.RechercheResultat;
import fr.fablabmars.vue.panneaux.SaveFailure;
import fr.fablabmars.vue.panneaux.SaveSuccess;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 8829645826951236028L;

	public Fenetre(){
		super();
		JPanel principal;
		Entete entete;
		ContainerGauche containerGauche = new ContainerGauche();
		CardMenu menu = new CardMenu();
		MenuGaucheControler controlMenu = new MenuGaucheControler(menu);
		containerGauche.setControler(controlMenu);
		
		ArrayList<ControlledPane> listPaneUtil = new ArrayList<ControlledPane>();
		listPaneUtil.add(new UtilisateurFormulaire(new QueryResult()));
		listPaneUtil.add(new SaveSuccess());
		listPaneUtil.add(new SaveFailure());
		
		ArrayList<ControlledPane> listPaneRech = new ArrayList<ControlledPane>();
		QueryResult qR = new QueryResult();
		listPaneRech.add(new RechercheFormulaire(qR));
		listPaneRech.add(new RechercheResultat(qR));
		
		ArrayList<ControlledPane> listPaneContainer = new ArrayList<ControlledPane>();
		listPaneContainer.add(new Accueil());
		listPaneContainer.add(new CardMenuPanel(listPaneUtil,new MenuUtilisateurControler(new CardMenu())));
		listPaneContainer.add(new CardMenuPanel(listPaneRech,new MenuRechercheControler(new CardMenu())));
		CardMenuPanel containerDroit = new CardMenuPanel(listPaneContainer,controlMenu);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle tailleEcran=graphicsEnvironment.getMaximumWindowBounds();
		int hauteur = (int)(tailleEcran.getHeight()*0.75);
		int largeur = (int)(hauteur*4/3);
		int posX = (int)tailleEcran.getWidth()/2-largeur/2;
		int posY = (int)tailleEcran.getHeight()/2-hauteur/2;
		
		this.setMinimumSize(new Dimension((int)(800*4/3),800));
		this.setLocation(posX,posY);
		this.setResizable(true);
		this.setSize(largeur, hauteur);
		this.setTitle("FablabUsers");

		try {
			Image img = ImageIO.read(new File("Icone.png"));
			this.setIconImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		principal = new JPanel();
		principal.setBackground(Color.WHITE);
		principal.setLayout(new BorderLayout());
		
		entete = new Entete("Logo150x150.png");
		principal.add(entete, BorderLayout.NORTH);
		
		principal.add(containerGauche,BorderLayout.WEST);
		
		principal.add(containerDroit,BorderLayout.CENTER);

		this.setContentPane(principal);
		this.setVisible(true);
		
	}

}


