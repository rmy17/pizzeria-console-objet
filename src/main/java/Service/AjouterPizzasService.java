package Service;

import java.util.Scanner;

import DAO.IPizzaDao;
import exception.SavePizzaException;
import exception.StockageException;
import model.CategoriePizza;
import model.Pizza;

public class AjouterPizzasService extends MenuService {

	public void executeUC(Scanner scanner, IPizzaDao memPizza) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("Ajout d'une nouvelle pizza");

		boolean except = false;
		String code = "";
		while (except != true) {
			System.out.println("Veuillez saisir le code :");
			code = scanner.nextLine();
			if (code.length() == 3) {
				// throw new SavePizzaException("Veuillez saisir un code de 3 lettres");
				if (memPizza.pizzaExists(code) == true) {
					// throw new SavePizzaException("Ce code existe déjà, rentrer un autre code");
					except = true;
				}
			}

		}
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix :");
		String prixstr = scanner.nextLine();
		double prix = Double.parseDouble(prixstr);
		if (prix < 0 || prix > 30) {
			throw new SavePizzaException("Donner un prix positif et inférieur à 30");
		}

		System.out.println("Veuillez choisir le categorie de pizza : Viande, Poisson ou Sans Viande");
		String cat = scanner.nextLine();
		CategoriePizza cate = CategoriePizza.recupCat(cat);
		Pizza nouv = new Pizza(code, nom, prix, cate);

		memPizza.saveNewPizza(nouv);
	}
}
