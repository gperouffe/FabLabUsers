package fr.fablabmars.model;

public class Contact {
	protected int id;
	protected String nom;
	protected String prenom;
	protected String etab;
	protected String adresse;
	protected String numero;
	protected String email;
	
	public Contact(){
		this.id = 0;
		this.nom = "";
		this.prenom = "";
		this.etab = "";
		this.adresse = "";
		this.numero = "";
	}
	
	public Contact(int id,String nom,String prenom,String etab,String adresse,String numero,String email){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etab = etab;
		this.adresse = adresse;
		this.numero = numero;
		this.email = email;
	}
	
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
