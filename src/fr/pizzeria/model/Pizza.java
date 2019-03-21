package fr.pizzeria.model;

/**
 * 
 * @author rmy17
 *
 */
public class Pizza {
	private int id;
	private String code;
	private String libelle;
	private double prix;
	private static int cpt = 1;
	private CategoriePizza catPizza;
	
	/**
	 * Constructor
	 * 
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza catPizza) {
		cpt++;
		this.id = cpt;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.catPizza = catPizza;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza catPizza) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.catPizza = catPizza;
	}
	
	public String toString() {
		return this.code+" -> "+this.libelle+" ("+this.prix+")"+" categorie de la pizza : "+this.catPizza;
	}
	/**
	 * Getter
	 * 
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Getter
	 * 
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Getter
	 * 
	 * @return libelle
	 */
	public String getLibelle(){
		return this.libelle;
	}
	
	/**
	 * Getter
	 * 
	 * @return prix
	 */
	public double getPrix(){
		return this.prix;
	}
	
	/**
	 * Setter
	 * 
	 * @param newCode
	 * 			the code to set
	 */
	public void setCode(String newCode){
		this.code = newCode;
	}
	
	/** 
	 * Setter
	 * 
	 * @param newLibelle
	 * 			the libelle to set
	 */
	public void setLibelle(String newLibelle){
		this.libelle = newLibelle;
	}
	
	/**
	 * Setter
	 * 
	 * @param newPrix
	 * 			the prix to set
	 */
	public void setPrix(double newPrix) {
		this.prix = newPrix;
	}
}
