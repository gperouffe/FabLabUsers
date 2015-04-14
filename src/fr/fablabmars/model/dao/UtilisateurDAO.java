package fr.fablabmars.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fablabmars.model.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {
	
	public UtilisateurDAO(Connection conn){
		super(conn);
		
	}

	@Override
	public boolean create(Utilisateur util) {
		
		String query = new String("INSERT INTO `gestionfablab`.`utilisateur`"+
									"(`nom`,"+
									"`prenom`,"+
									"`etab`,"+
									"`adresse`,"+
									"`numero`,"+
									"`email`,"+
									"`professionnel`,"+
									"`cotisant`)"+
								"VALUES(?,?,?,?,?,?,?,?);");

		PreparedStatement prepare = null; 		
		try {
			prepare =  this.connect.prepareStatement(query);
			prepare.setString(1, util.getNom());
			prepare.setString(2, util.getPrenom());
			prepare.setString(3, util.getEtab());
			prepare.setString(4, util.getAdresse());
			prepare.setString(5, util.getNumero());
			prepare.setString(6, util.getEmail());
			prepare.setBoolean(7, util.isPro());
			prepare.setBoolean(8, util.isCotisant());
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try{
				prepare.close();
			}
			catch(SQLException ex){}
			return false;
		}
		try{
			prepare.close();
		}
		catch(SQLException ex){}
		return true;
	}

	@Override
	public boolean delete(Utilisateur util) {
		
		return false;
	}

	@Override
	public boolean update(Utilisateur util) {
		
		return false;
	}

	@Override
	public Utilisateur load(int id) {
		Utilisateur util = new Utilisateur();
		
		String query = new String("SELECT * FROM gestionfablab.utilisateur WHERE utilisateur.id = ?");
		
		PreparedStatement prepare = null;
		
		try{
			prepare = this.connect.prepareStatement(query);
			prepare.setInt(1, id);
			
			ResultSet res = prepare.executeQuery();
			 
			if(res.first()){
				util = new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getString("etab"),res.getString("adresse"),res.getString("numero"),res.getString("email"),res.getBoolean("professionnel"),res.getBoolean("cotisant"));
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try{
				prepare.close();
			}
			catch(SQLException ex){}
			return null;
		}
		try{
			prepare.close();
		}
		catch(SQLException ex){}
		return util;
	}

	@Override
	public ArrayList<Utilisateur> find(ArrayList<String> nomPrenom) {
		ArrayList<Utilisateur> utils = new ArrayList<Utilisateur>();
		
		String query = new String("SELECT * FROM `gestionfablab`.`utilisateur` WHERE `nom` = ? AND `prenom` = ?");
		
		PreparedStatement prepare = null;
		
		try{
			prepare = this.connect.prepareStatement(query);

			prepare.setString(1, nomPrenom.get(0));
			prepare.setString(2, nomPrenom.get(1));
			
			ResultSet res = prepare.executeQuery();
			 
			if(res.first() && res.isLast()){
				utils.add(new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getString("etab"),res.getString("adresse"),res.getString("numero"),res.getString("email"),res.getBoolean("professionnel"),res.getBoolean("cotisant")));
			}
			else if (res.isAfterLast()){}
			else{
				res.beforeFirst();
				while(res.next()){
					utils.add(new Utilisateur(res.getInt("id"),res.getString("nom"),res.getString("prenom"),res.getString("etab"),res.getString("adresse"),res.getString("numero"),res.getString("email"),res.getBoolean("professionnel"),res.getBoolean("cotisant")));
				}
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try{
				prepare.close();
			}
			catch(SQLException ex){}
			return null;
		}
		try{
			prepare.close();
		}
		catch(SQLException ex){}
		return utils;
	}
	
}