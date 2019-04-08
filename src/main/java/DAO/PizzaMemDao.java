package DAO;

import java.util.ArrayList;

import model.CategoriePizza;
import model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private ArrayList<Pizza> pizzas;

	public PizzaMemDao() {

		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

		Pizza p1 = new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.SANS_VIANDE);
		Pizza p2 = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		Pizza p3 = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		Pizza p4 = new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		Pizza p5 = new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		Pizza p6 = new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		Pizza p7 = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		Pizza p8 = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE);
		pizzas.add(p1);
		pizzas.add(p2);
		pizzas.add(p3);
		pizzas.add(p4);
		pizzas.add(p5);
		pizzas.add(p6);
		pizzas.add(p7);
		pizzas.add(p8);
		this.pizzas = pizzas;
	}

	@Override
	public ArrayList<Pizza> findAllPizzas() {
		return this.pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		int pos;
		for (Pizza pi : pizzas) {
			if (pi != null && pi.getCode().equals(codePizza)) {
				pos = pizzas.indexOf(pi);
				pi = pizza;
				pizzas.set(pos, pi);
				break;
			}
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		Pizza piz = new Pizza();
		for (Pizza pi : pizzas) {
			if (pi != null && pi.equals(findPizzaByCode(codePizza))) {
				piz = pi;
			}
		}
		pizzas.remove(piz);
		System.out.println("pizza supprimé !");
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for (Pizza pi : pizzas) {
			if (pi != null && pi.getCode().equals(codePizza)) {
				return pi;
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean b = false;
		for (Pizza pi : pizzas) {
			if (pi != null && pi.getCode().equals(codePizza)) {
				b = true;
				break;
			}
		}
		return b;
	}

}
