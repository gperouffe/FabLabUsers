package fr.fablabmars.model;

/**
 * Modélisation d'un contact.
 * 
 * @author Guillaume Perouffe
 *
 */
public class Contact {
	
	/**
	 * ID
	 */
	protected int id;
	
	/**
	 * Nom
	 */
	protected String nom;
	
	/**
	 * Prenom
	 */
	protected String prenom;
	
	/**
	 * Etablissement d'origine
	 */
	protected String etab;
	
	/**
	 * Addresse (format HTML)
	 */
	protected String adresse;
	
	/**
	 * Numero de téléphone
	 */
	protected String numero;
	
	/**
	 * Addresse email
	 */
	protected String email;
	
	/**
	 * Constructeur par défaut
	 */
	public Contact(){
		this.id = 0;
		this.nom = "";
		this.prenom = "";
		this.etab = "";
		this.adresse = "";
		this.numero = "";
	}
	
	/**
	 * Constructeur de Contact
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param etab
	 * @param adresse
	 * @param numero
	 * @param email
	 */
	public Contact(int id,String nom,String prenom,String etab,String adresse,String numero,String email){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etab = etab;
		this.adresse = adresse;
		this.numero = numero;
		this.email = email;
	}
	
	/**
	 * Constructeur par copie
	 * 
	 * @param C
	 * 			Contact à copier
	 * 
	 */
	public Contact(Contact C){
		C.id = id;
		C.nom = new String(nom);
		C.prenom =  new String(prenom);
		C.etab =  new String(etab);
		C.adresse =  new String(adresse);
		C.numero =  new String(numero);
		C.email =  new String(email);
	}
	
	@Override
	public String toString() {
		return "Contact :\n" + nom +" "+ prenom + "\n"
			+ numero + "\n" + adresse + "\n" + email +"\n"+ "n°" + id +"\n";
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtab() {
		return etab;
	}

	public void setEtab(String etab) {
		this.etab = etab;
	}
	
	
}
