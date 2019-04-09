package Service;

import java.util.List;
import java.util.Scanner;

import DAO.IPizzaDao;
import model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) {
		System.out.println("Liste pizzas");
		List<Pizza> pizzas = memPizza.findAllPizzas();
		for (Pizza pi : pizzas) {
			if (pi != null) {
				System.out.println(pi);
			}
		}
	}
}