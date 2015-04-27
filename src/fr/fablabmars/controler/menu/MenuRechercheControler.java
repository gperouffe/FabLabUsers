package fr.fablabmars.controler.menu;

import fr.fablabmars.model.CardMenu;

/**
 * Contrôleur du menu de recherche.
 * 
 * @author Guillaume Perouffe
 *
 */
public class MenuRechercheControler extends MenuAbstractControler{
	
	/**
	 * Constructeur du menu de recherche.
	 * 
	 * @param MenuRecherche
	 *			Observable retenant le menu courant.
	 *
	 *@see CardMenu
	 */
	public MenuRechercheControler(CardMenu MenuRecherche){
		super(MenuRecherche);
	}

	@Override
	public void control(String bouton) {
		if(bouton.contains("Succès")){
			((CardMenu)this.obs).setPanel(1);		
			}
		else if(bouton.contains("Echec")){
			((CardMenu)this.obs).setPanel(0);
		}
		else if(bouton.contains("Facture")){
			((CardMenu)this.obs).setPanel(2);
		}
		else if(bouton.contains("Cotisation")){
			((CardMenu)this.obs).setPanel(3);
		}
		else if(bouton.contains("Modifier")){
			((CardMenu)this.obs).setPanel(4);
		}
		else if(bouton.contains("Retour")){
			((CardMenu)this.obs).setPanel(0);
		}
	}

}