package fr.fablabmars.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<T> {
	  protected Connection connect = null;
	   
	  public DAO(Connection conn){
	    this.connect = conn;
	  }

	  public abstract boolean create(T obj);

	  public abstract boolean delete(T obj);

	  public abstract boolean update(T obj);

	  public abstract T load(int id);
	  
	  public abstract ArrayList<T> find(ArrayList<String> params);
	}
