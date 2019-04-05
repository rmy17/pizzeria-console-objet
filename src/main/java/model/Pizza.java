package model;

import java.lang.reflect.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.ToString;

/**
 * 
 * @author rmy17
 *
 */
@Entity
@Table(name = "pizzas")
public class Pizza {
	@Id
	@Column(name="ID")
	private int id;
	@ToString(upper = true)
	@Column(name="CODE")
	private String code;
	@ToString(upper = true, after = " |")
	@Column(name="LIBELLE")
	private String libelle;
	@ToString(upper = false,after = "\u20AC |")
	@Column(name="PRIX")
	private double prix;
	private static int cpt = 1;
	@ToString(upper = true, after = "")
	@Column(name="CATEGORIE")
	@Enumerated(EnumType.STRING)
	private CategoriePizza catPizza;
	
	
	public Pizza() {
		
		cpt++;
		this.code = "";
		this.libelle = "";
		this.prix = 0;
		this.catPizza = CategoriePizza.POISSON ;
		
	}
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
		String chaine = "";
		Class classe = getClass();
		Field[] fields = classe.getDeclaredFields();

		for (Field attribut: fields){
			if (attribut.isAnnotationPresent(ToString.class)){

				

				ToString annotation = attribut.getAnnotation(ToString.class);
				boolean uppercase = annotation.upper();
				String before = annotation.before();
				String after = annotation.after();
				

				try {
					chaine+=before;
					if (uppercase){
						chaine+=attribut.get(this).toString().toUpperCase();
					}
					else {
						chaine+=attribut.get(this);
					}
					chaine+=after;
				} catch (IllegalArgumentException | IllegalAccessException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				} 

			}

		}

		return chaine;
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
	
	public CategoriePizza getCate() {
		return this.catPizza;
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
	
	public void setCatPizza(CategoriePizza catPizza) {
		this.catPizza = catPizza;
	}
	
	
}
