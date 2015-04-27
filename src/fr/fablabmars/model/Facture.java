package fr.fablabmars.model;

/**
 * Mod�lisation d'une facture.
 * 
 * @author Guillaume Perouffe
 *
 */
public class Facture {
	
	/**
	 * Destinataire de la facture
	 * 
	 * @see Utilisateur
	 */
	private Utilisateur U;
	
	/**
	 * Intitul� de la prestation 
	 */
	private String prestation = "";
	
	/**
	 * Dur�e de la prestation
	 */
	private double tempsUtilisation;
	
	/**
	 * Tarif horaire
	 */
	private double tarif;
	
	/**
	 * Total � payer
	 */
	private double total;
	
	/**
	 * Constructeur de Facture 
	 * 
	 * @param U
	 *			Destinataire de la facture 
	 * @param presta
	 * 			Type de prestation
	 * @param tarif
	 * 			Tarif de la prestation
	 * @param temps
	 *			Dur�e de la prestation
	 *
	 *@see Facture#U
	 *@see Facture#prestation
	 *@see Facture#tarif
	 *@see Facture#tempsUtilisation
	 */
	public Facture(Utilisateur U,String presta, double tarif, double temps){
		this.U = U;
		this.prestation=presta;
		this.tarif = tarif;
		this.tempsUtilisation = temps;
		this.total= temps*tarif;
		
	}

	@Override
	public String toString() {
		return "Facture \n------\n"+ U + "\nPrestation : " + prestation
				+ "\nTemps d'utilisation : " + tempsUtilisation + " h\nTarif : " + tarif
				+ " Eur/h\nTotal : " + total +" Eur\n------";
	}
	
}
