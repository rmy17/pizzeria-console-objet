package console;

import java.util.Scanner;

import DAO.IPizzaDao;
import DAO.PizzaJDBCDao;
import DAO.PizzaJPADao;
import DAO.PizzaFileDao;
import DAO.PizzaMemDao;
import Service.MenuFactory;
import exception.SavePizzaException;
import exception.StockageException;
import model.CategoriePizza;


public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		//IPizzaDao memPizza = new PizzaMemDao();
		//IPizzaDao filePizza = new PizzaFileDao();
		//IPizzaDao daoPizza = new PizzaJDBCDao();
		IPizzaDao daoPizza = new PizzaJPADao();
		
		MenuFactory mf = new MenuFactory();
		Scanner sc = new Scanner(System.in);
		//test
		CategoriePizza.recupCat("Viande");
		//test
		boolean on = true;
		while (on == true) {
			System.out.println("Bonjour test !");
			System.out.println("1. Lister les pizza");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			//System.out.println("5. Sauvegarder la liste de pizza dans un fichier");
			System.out.println("99. Sortir");
			System.out.println("Que voulez vous faire ? Tapez le numéro de la proposition pour faire un choix");
			String rep = sc.nextLine();
			int val = 0;
			try
			{
				val = Integer.parseInt(rep);
				switch (val) {
				case 1:
					mf.create("Lister").executeUC(sc, daoPizza);
					break;
				case 2:
					mf.create("Ajouter").executeUC(sc, daoPizza);
					break;
				case 3:
					mf.create("Modifier").executeUC(sc, daoPizza);
					break;
				case 4:
					mf.create("Supprimer").executeUC(sc, daoPizza);
					break;
				case 5:
					mf.create("Sauvegarder").executeUC(sc,daoPizza);
				case 99:
					on = false;
					System.out.println("Au revoir \u2639");
					break;
				default:
					System.out.println("Erreur votre choix n'est pas correct !");
				}
			}
			catch (NumberFormatException e) {
				val = 0;
			}
			catch (SavePizzaException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
			catch(StockageException e ) {
				System.out.println(e.getMessage());
			}
			
			
		}
		sc.close();
	}
}
