package DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import exception.MySqlSException;
import model.CategoriePizza;
import model.Pizza;

public class PizzaJDBCDao implements IPizzaDao{

	private ArrayList<Pizza> pizzas;
	private String url = null;
	private String Dname = null;
	private String userName = null;
	private String password = null;
	private Connection con = null;
	private PreparedStatement st = null;
	
	
	public void beginConnectJbdc() {
		FileInputStream fis;
			
		try {
			fis = new FileInputStream("C:\\Users\\rmy17\\Documents\\workspace-sts-3.9.6.RELEASE\\pizzeria-console-objet\\src\\main\\java\\DAO\\jdbc.properties");
		
		Properties p = new Properties();
		p.load(fis); 
		Dname= (String) p.get ("Dname"); 
	    url= (String) p.get ("URL"); 
	        userName= (String) p.get ("Uname"); 
	        password= (String) p.get ("password");
	        Class.forName(Dname); 
	        con = DriverManager.getConnection( 
	                url, userName, password); 
	        con.setAutoCommit(false);
		}
	    catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void closeConnexionBdd ()
	{
		try
		{
			st.close ();
			con.close ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
}
	
	@Override
	public ArrayList<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		pizzas = new ArrayList <> ();
		try {
			beginConnectJbdc();
			st = con.prepareStatement("SELECT * from pizzas");
			ResultSet re = st.executeQuery();
			while(re.next()) 
			{ 
				String cat = re.getString(5);
				CategoriePizza cate = CategoriePizza.valueOf(cat.toUpperCase());
				pizzas.add(new Pizza(re.getInt(1),re.getString(2),re.getString(3),re.getDouble(4),cate));
			}
			closeConnexionBdd();
		} catch (SQLException e) {
			throw new MySqlSException("La récupération de la liste de pizza dans la base de donnée ne s'est pas déroulé correctement",e);
		}
		finally {
			closeConnexionBdd();
		}
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			beginConnectJbdc();
			st = con.prepareStatement("INSERT INTO pizzas (CODE,LIBELLE,PRIX,CATEGORIE) values (?,?,?,?);");
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getLibelle());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getCate().getNom());
			st.executeUpdate();
			
			con.commit();
			
			closeConnexionBdd();
			
		} catch (SQLException e) {
			throw new MySqlSException("La sauvegarde de la pizza ne s'est pas déroulé correctement",e);
		}
		finally {
			closeConnexionBdd();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		try {
			beginConnectJbdc();
			st = con.prepareStatement("UPDATE pizzas SET CODE = ?, LIBELLE = ?, PRIX = ?, CATEGORIE = ? WHERE = ?;");
		
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getLibelle());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getCate().getNom());
			st.setString(5, codePizza);
			st.executeUpdate();
			
			con.commit();
			closeConnexionBdd();
			
		} catch (SQLException e) {
			throw new MySqlSException("La modification de la pizza ne s'est pas effectué correctement",e);
		}
		finally {
			closeConnexionBdd();
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		try {
			beginConnectJbdc();
			st = con.prepareStatement("DELETE FROM pizzas WHERE CODE = ?;");
			st.setString(1, codePizza);
			st.executeUpdate();
			con.commit();
			closeConnexionBdd();
			
		} catch (SQLException e) {
			throw new MySqlSException("La suppresion de la pizza ne s'est pas effectué correctement",e);
		}
		finally {
			closeConnexionBdd();
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		int ID=0;
		String CODE ="";
		String LIBELLE ="";
		Double PRIX=0.0;
		String CATEGORIE="";
		Pizza pi = new Pizza();
		try {
			beginConnectJbdc();
			st = con.prepareStatement("SELECT * FROM pizzas WHERE CODE= ?;");
			st.setString(1, codePizza);
			ResultSet re = st.executeQuery();
			
			while(re.next()) {
				ID = re.getInt("ID");
				CODE = re.getString("CODE");
				LIBELLE = re.getString("LIBELLE");
				PRIX = re.getDouble("PRIX");
				CATEGORIE = re.getString("CATEGORIE");
				
			}
		closeConnexionBdd();
		pi = new Pizza(ID,CODE,LIBELLE,PRIX,CategoriePizza.valueOf(CATEGORIE.toUpperCase()));
		
		} catch (SQLException e) {
			throw new MySqlSException("La recherche de la pizza ne s'est pas effectué correctement",e);
		}
		finally {
			closeConnexionBdd();
		}
		return pi;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean test = false;
		int compteur = 0;
		beginConnectJbdc();
		try {
			st = con .prepareStatement("SELECT * FROM pizzas WHERE CODE= ?;");
			st.setString(1, codePizza);
			ResultSet re = st.executeQuery();
			while(re.next()) 
			{
				compteur++;
			}
			
			if (compteur == 1)
			{
				test = true;
			}
			con.commit();
			
			closeConnexionBdd();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new MySqlSException("Problème de vérification de la présence d'une pizza",e);
		}
		finally
		{
			closeConnexionBdd();
		}
		return test;
	}

	
}
