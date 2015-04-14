package fr.fablabmars.model;
import java.util.Scanner;


public class Facture {
	private Utilisateur U;
	private String prestation = "";
	private FicheTarifaire Fiche;
	private double tempsUtilisation;
	private double tarif=-1;
	private double total = 0;
	
	public Facture(FicheTarifaire F, Utilisateur U){
		this.U = U;
		U.prestation();
		Fiche = F;
	}

	public void edition(){
		Scanner sc = new Scanner(System.in);
		String ok = new String("N");
		@SuppressWarnings("unused")
		String videBuffer = new String("");
		do{
			System.out.println("EDITION DE FACTURE\n");
			System.out.println(Fiche);
			tarif = -1;
			tempsUtilisation=0;
			while(tarif==-1){
				System.out.println("Entrez le numero de la prestation : ");
				if(sc.hasNextInt()){
					int i = sc.nextInt();
					tarif = Fiche.tarifNumero(i);
					prestation = Fiche.prestaNumero(i);
					videBuffer=sc.nextLine();
				}
				else{
					videBuffer=sc.nextLine();
				}
			}
			while(tempsUtilisation==0){
				System.out.println("Entrez le temps d'utilisation (heures) : ");
				if(sc.hasNextDouble()){
					tempsUtilisation = sc.nextDouble();
					videBuffer=sc.nextLine();
				}
				else{
					videBuffer=sc.nextLine();
				}
			}
			total = tempsUtilisation*tarif;
			System.out.println(this);
			System.out.println("Valider cette facture?Y/N");
			ok = sc.nextLine();
		}while(!"Y".equals(ok));
		System.out.println("FIN EDITION");
		sc.close();
	}

	@Override
	public String toString() {
		return "Facture \n------\n"+ U + "\nPrestation : " + prestation
				+ "\nTemps d'utilisation : " + tempsUtilisation + " h\nTarif : " + tarif
				+ " Eur/h\nTotal : " + total +" Eur\n------";
	}
	
}
