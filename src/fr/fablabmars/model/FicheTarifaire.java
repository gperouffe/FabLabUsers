package fr.fablabmars.model;
import java.util.ArrayList;

/**
 * Modélisation de la Fiche tarifaire
 * 
 * @author Guillaume Perouffe
 *
 */
public class FicheTarifaire {
	
	/**
	 * Liste des intitulés des prestations
	 */
	private ArrayList<String> fichePresta;
	
	/**
	 * Tarifs des prestations
	 */
	private ArrayList<Double> ficheTarifs;
	
	/**
	 * Constructeur par défaut
	 */
	public FicheTarifaire(){
		fichePresta= new ArrayList<String>();
		ficheTarifs = new ArrayList<Double>();
	}
	
	/**
	 * Constructeur par copie
	 * 
	 * @param F
	 *			Fiche tarifaire à copier
	 */
	public FicheTarifaire(FicheTarifaire F){
		fichePresta=new ArrayList<String>(F.fichePresta);
		ficheTarifs=new ArrayList<Double>(F.ficheTarifs);
	}
	
	/**
	 * Recherche le tarif pour la prestation portant le nom p
	 * 
	 * @param p
	 * 			Nom de la prestation à chercher
	 * @return Tarif de p si p existe, -1 sinon.
	 */
	public double cherchePresta(String p){
		for(int i = 0; i<fichePresta.size(); i++){
			if(fichePresta.get(i)==p){
				return ficheTarifs.get(i);
			}
		}
		return -1;
	}
	
	/**
	 * Renvoie le tarif no i
	 * 
	 * @param i
	 * 			Id de la prestation dont on veut le tarif
	 * @return Tarif numero i s'il existe, -1 sinon
	 */
	public double tarifNumero(int i){
		if(i>ficheTarifs.size()|| i<=0){
			return -1;
		}
			return ficheTarifs.get(i-1);
	}
	
	/**
	 * Renvoie l'intitulé de la prestation no i
	 * 
	 * @param i
	 * 			Id de la prestation à renvoyer
	 * @return Prestation no i si elle existe, "" sinon
	 */
	public String prestaNumero(int i){
		if(i>fichePresta.size()|| i<=0){
			return "";
		}
			return fichePresta.get(i-1);
	}
	
	/**
	 * Ajoute une prestation à la Fiche tarifaire
	 * 
	 * @param p
	 * 			Intitulé à rajouter
	 * @param t
	 * 			Tarif à rajouter
	 */
	public void ajoutePresta(String p, double t){
		if(cherchePresta(p)==-1){
			fichePresta.add(p);
			ficheTarifs.add(t);
		}
	}

	@Override
	public String toString() {
		String temp = new String("\n------\n");
		for(int i = 0; i < fichePresta.size(); i++){
			temp = temp + (i+1) +". "+ fichePresta.get(i) + " " + ficheTarifs.get(i) + " Eur/h\n";
		}
		temp = temp +"------";
		return "Fiche Tarifaire " + temp;
	}
	
}
