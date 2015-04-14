package fr.fablabmars.model;

public class Utilisateur extends Contact {
		private Boolean cotisant;
		private Boolean pro;
		private int nombrePrestations;
		
		public Utilisateur(){
			super();
			cotisant = false;
			pro = false;
			nombrePrestations = 0;
		}
		
		public Utilisateur(int id,String nom,String prenom,String etab,String adresse,String numero,String email, Boolean pro,Boolean cotisant){
			super(id,nom,prenom,etab,adresse,numero,email);
			this.cotisant = cotisant;
			this.pro = pro;
			nombrePrestations = 0;
		}
		
		public Utilisateur(String nom,String prenom,String etab,String adresse,String numero,String email, Boolean pro){
			super(-1,nom,prenom,etab,adresse,numero,email);
			cotisant = false;
			this.pro = pro;
			nombrePrestations = 0;
		}
		
		public Utilisateur(Contact C){
			super(C);
			cotisant = false;
			pro = false;
			nombrePrestations = 0;
		}
		
		public Utilisateur(Utilisateur C){
			super(C.id,C.nom, C.prenom, C.etab, C.adresse, C.numero, C.email);
			cotisant = C.cotisant;
			pro=C.pro;
			nombrePrestations = C.nombrePrestations;
		}
		
		public void prestation(){
			nombrePrestations++;
		}
		
		public void cotisation(){
			this.cotisant = true;
		}
 
		public Boolean isCotisant() {
			return cotisant;
		}

		public int getNombrePrestations() {
			return nombrePrestations;
		}

		@Override
		public String toString() {
			return super.toString() + "\nInfos Utilisateur cotisant=" + cotisant + ", nombrePrestations="
					+ nombrePrestations + ", pro=" + pro + "\n";
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

		public void setNombrePrestations(int nombrePrestations) {
			this.nombrePrestations = nombrePrestations;
		}
		
}

