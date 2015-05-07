package fr.fablabmars.controler.formulaire;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.fablabmars.model.bdd.ConnectionFabLab;
import fr.fablabmars.model.bdd.QueryResult;

/**
 * Contr�leur d�di� � la connexion BDD depuis la page d'acceuil.
 * 
 * @author Guillaume Perouffe
 */
public class FormulaireAcceuilControler extends FormulaireAbstractControler<ArrayList<String>> {

	/**
	 * Constructeur du contr�leur du formulaire de connexion.
	 * 
	 * @param
	 */
	public FormulaireAcceuilControler(QueryResult qR) {
		super(null, qR);
	}
	
	/**
	 * Contr�le les donn�es (nom, pr�nom) sur l'utilisateur recherch�.
	 * 
	 * @param nomPrenom
	 * 			Arraylist contenant le nom et le pr�nom de l'utilisateur recherch�.
	 */
	@Override
	public void control(ArrayList<String> infosConn) {
		
		if(infosConn!=null){
			ConnectionFabLab.setUrl(infosConn.get(0));
			ConnectionFabLab.setUser(infosConn.get(1));
			ConnectionFabLab.setPasswd(infosConn.get(2));
		
			if(ConnectionFabLab.getInstance()==null){
				((QueryResult)this.obs).failure();
			}
			else{
				((QueryResult)this.obs).success();
			}
		}
		else{
			try {
				if(ConnectionFabLab.getInstance()!=null){
					ConnectionFabLab.getInstance().close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				((QueryResult)this.obs).failure();
			}
		}
	}
}