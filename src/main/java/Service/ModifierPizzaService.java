package Service;

import java.util.Scanner;

import DAO.IPizzaDao;
import exception.StockageException;
import exception.UpdatePizzaException;
import model.CategoriePizza;
import model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("Mise à jour d'une pizza");
		ListerPizzasService l = new ListerPizzasService();
		l.executeUC(scanner, memPizza);
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String code = scanner.nextLine();
		if (memPizza.pizzaExists(code) == false) {
			throw new UpdatePizzaException("Le code rentré ne correspond à aucune pizza !");
		}
		System.out.println("Veuillez saisir le nouveau code");
		String newCode = scanner.nextLine();
		System.out.println("Veuillez saisir le nouveau nom (sans espace)");
		String newNom = scanner.nextLine();
		System.out.println("Veuillez saisir le nouveau prix");
		String newPrixStr = scanner.nextLine();
		Double newPrix = Double.parseDouble(newPrixStr);
		System.out.println("Veuillez saisir la nouvelle categorie !");
		String newCat = scanner.nextLine();
		CategoriePizza cat = CategoriePizza.valueOf(newCat);
		memPizza.updatePizza(code, new Pizza(newCode, newNom, newPrix, cat));
	}

}
