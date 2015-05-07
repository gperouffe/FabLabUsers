package fr.fablabmars.model;

/**
 * Modélisation d'un utilisateur
 * 
 * @author Guillaume Perouffe
 *
 */
public class Utilisateur extends Contact {
		
	/**
	 * Indicateur de cotisation	
	 */
	private Boolean cotisant;
	
	/**
	 * Indique si l'utilisateur est particulier ou professionnel
	 */
	private Boolean pro;
	
	/**
	 * Nombre de factures éditées à ce nom
	 */
	private int nombreFacture;
	
	/**
	 * Constructeur par défaut
	 */
	public Utilisateur(){
		super();
		cotisant = false;
		pro = false;
		nombreFacture = 0;
	}
	
	/**
	 * Constructeur d'Utilisateur avec ID
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param etab
	 * @param adresse
	 * @param numero
	 * @param email
	 * @param pro
	 * @param cotisant
	 */
	public Utilisateur(int id,String nom,String prenom,String etab,String adresse,String numero,String email, Boolean pro,Boolean cotisant){
		super(id,nom,prenom,etab,adresse,numero,email);
		this.cotisant = cotisant;
		this.pro = pro;
		nombreFacture = 0;
	}
	
	/**
	 * Constructeur d'Utilisateur sans ID
	 * 
	 * @param nom
	 * @param prenom
	 * @param etab
	 * @param adresse
	 * @param numero
	 * @param email
	 * @param pro
	 */
	public Utilisateur(String nom,String prenom,String etab,String adresse,String numero,String email, Boolean pro){
		super(-1,nom,prenom,etab,adresse,numero,email);
		cotisant = false;
		this.pro = pro;
		nombreFacture = 0;
	}
		
	/**
	 * Nouvel utilisateur à partir d'un contact existant
	 * 
	 * @param C
	 * 			Informations de contact à récupérer
	 */
	public Utilisateur(Contact C){
		super(C);
		cotisant = false;
		pro = false;
		nombreFacture = 0;
	}
	
	/**
	 * Constructeur par copie
	 * 
	 * @param C
	 */
	public Utilisateur(Utilisateur C){
		super(C.id,C.nom, C.prenom, C.etab, C.adresse, C.numero, C.email);
		cotisant = C.cotisant;
		pro=C.pro;
		nombreFacture = C.nombreFacture;
	}
	
	public void prestation(){
		nombreFacture++;
	}
	
	public void cotisation(){
		this.cotisant = true;
	}

	public Boolean isCotisant() {
		return cotisant;
	}

	public int getNombrePrestations() {
		return nombreFacture;
	}

	@Override
	public String toString() {
		return super.toString() + "\nInfos Utilisateur cotisant=" + cotisant + ", nombrePrestations="
				+ nombreFacture + ", pro=" + pro + "\n";
	}

	public Boolean getCotisant() {
		return cotisant;
	}

	public void setCotisant(Boolean cotisant) {
		this.cotisant = cotisant;
	}

	public Boolean isPro() {
		return pro;
	}

	public void setPro(Boolean pro) {
		this.pro = pro;
	}

	public void setNombreFacture(int nombreFacture) {
		this.nombreFacture = nombreFacture;
	}
	
}

