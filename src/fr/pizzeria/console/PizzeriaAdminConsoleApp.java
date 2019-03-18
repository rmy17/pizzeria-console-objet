package fr.pizzeria.console;

import fr.pizzeria.model.*;
import java.util.*;
public class PizzeriaAdminConsoleApp {

	public static void main(String []args) {
		Pizza p1 = new Pizza(0,"PEP","Pépéroni",12.50);
		Pizza p2 = new Pizza(1,"MAR","Margherita",14.00);
		Pizza p3 = new Pizza(2,"REIN","La Reine",11.50);
		Pizza p4 = new Pizza(3,"FRO","La 4 fromages",12.00);
		Pizza p5 = new Pizza(4,"CAN","La cannibale",12.50);
		Pizza p6 = new Pizza(5,"SAV","La savoyarde",13.00);
		Pizza p7 = new Pizza(6,"ORI","L'orientale",13.50);
		Pizza p8 = new Pizza(7,"IND","L'indienne",14.00); 
		Pizza[] pizza = {p1,p2,p3,p4,p5,p6,p7,p8};
		int cpt = 7;
		Scanner sc = new Scanner(System.in);
		boolean on = true;
		while (on == true) {
			System.out.println("1. Lister les pizza\n2. Ajouter une nouvelle pizza\n3. Mettre à jour une pizza\n4. Supprimer une pizza\n99. Sortir");
			System.out.println("Bonjour !");
			System.out.println("Que voulez vous faire ? Tapez le numéro de la proposition pour faire un choix");
			String rep = sc.nextLine();
			int val = Integer.parseInt(rep);
			switch(val) {
			case 1 :
				System.out.println("Liste pizzas");
				affiche(pizza);
				break;
			case 2 :
				cpt++;
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code :");
				String code = sc.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String nom = sc.nextLine();
				System.out.println("Veuillez saisir le prix :");
				String prixstr = sc.nextLine();
				double prix = Double.parseDouble(prixstr); 
				Pizza nouv = new Pizza(code,nom, prix);
				pizza[cpt]=nouv;
				break;
			case 3 :
				System.out.println("Mise à jour d'une pizza");
				affiche(pizza);
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				code = sc.nextLine();
				int nb = recupPizza(code,pizza);
				System.out.println("Veuillez saisir le nouveau code");
				code = sc.nextLine();
				pizza[nb].setCode(code);
				System.out.println("Veuillez saisir le nouveau nom (sans espace)");
				code = sc.nextLine();
				pizza[nb].setLibelle(code);
				String newPrixStr = sc.nextLine();
				Double newPrix = Double.parseDouble(newPrixStr);
				pizza[nb].setPrix(newPrix); 
			case 4:
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer :");
				code = sc.nextLine();
				nb = recupPizza(code, pizza);
				pizza[nb]=null;
				break;
			case 99:
				on = false;
				System.out.println("Au revoir \u2639");
			}
		}
		sc.close();
	}
	
	public static void affiche(Pizza[] pizza) {
		for(Pizza pi : pizza){
			System.out.println(pi.getCode()+" -> "+pi.getLibelle()+"("+pi.getPrix()+" €"+")"); 
		}
	}
	
	public static int recupPizza(String code, Pizza [] pizza) {
		for(int i = 0; i<pizza.length;i++) {
			if(pizza[i] != null && pizza[i].getCode().equals(code)) {
				return i;
			}
		}
		return -1;
	}
}
