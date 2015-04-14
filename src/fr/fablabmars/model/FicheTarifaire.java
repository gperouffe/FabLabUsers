package fr.fablabmars.model;
import java.util.ArrayList;

public class FicheTarifaire {
	private ArrayList<String> fichePresta;
	private ArrayList<Double> ficheTarifs;
	
	public FicheTarifaire(){
		fichePresta= new ArrayList<String>();
		ficheTarifs = new ArrayList<Double>();
	}
	
	public FicheTarifaire(FicheTarifaire F){
		fichePresta=new ArrayList<String>(F.fichePresta);
		ficheTarifs=new ArrayList<Double>(F.ficheTarifs);
	}
	
	public double cherchePresta(String p){
		for(int i = 0; i<fichePresta.size(); i++){
			if(fichePresta.get(i)==p){
				return ficheTarifs.get(i);
			}
		}
		return -1;
	}
	
	public double tarifNumero(int i){
		if(i>ficheTarifs.size()|| i<=0){
			return -1;
		}
			return ficheTarifs.get(i-1);
	}
	
	public String prestaNumero(int i){
		if(i>fichePresta.size()|| i<=0){
			return "";
		}
			return fichePresta.get(i-1);
	}
	
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
