package DAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.CategoriePizza;
import model.Pizza;

public class PizzaMemDaoTest {

	@Test
	public void findAllPizzas() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		List list = pizzaMemDao.findAllPizzas();
		Assert.assertTrue(list.get(0).getClass().equals(Pizza.class));
	}

	@Test
	public void testSaveNewPizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		ArrayList<Pizza> pizz = new ArrayList();

		pizz = pizzaMemDao.findAllPizzas();
		int tailleInit = pizz.size();
		Pizza new_p = new Pizza(8, "IOD", "L'indoienne", 14.00, CategoriePizza.VIANDE);
		pizzaMemDao.saveNewPizza(new_p);
		Assert.assertTrue(pizzaMemDao.findAllPizzas().size() == (tailleInit + 1));
	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		ArrayList<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		pizzaMemDao.saveNewPizza(new Pizza(8, "IOD", "L'indoienne", 14.00, CategoriePizza.VIANDE));
		pizzaMemDao.updatePizza("IOD", new Pizza(9, "IOP", "L'indopienne", 15.00, CategoriePizza.VIANDE));
		for (Pizza p : pizzas) {
			if (p != null && p.getCode().equals("IOP")) {
				Assert.assertTrue(p.getLibelle().equals("L'indopienne"));
				Assert.assertTrue(p.getPrix() == 15.00);
				Assert.assertTrue(p.getCate() == CategoriePizza.VIANDE);
			}
		}
	}

	@Test
	public void testDeletePizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		ArrayList<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		int tailleInit = pizzas.size();
		Pizza pizza = pizzas.get(0);
		pizzaMemDao.deletePizza(pizza.getCode());
		Assert.assertNotEquals(pizzaMemDao.findAllPizzas().size(), tailleInit);
	}

	@Test
	public void findPizzaByCode() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		ArrayList<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		Pizza piz = pizzaMemDao.findPizzaByCode(pizzas.get(0).getCode());
		Assert.assertTrue(piz.getId() == pizzas.get(0).getId());
		Assert.assertTrue(piz.getCode().equals(pizzas.get(0).getCode()));
		Assert.assertTrue(piz.getPrix() == pizzas.get(0).getPrix());
		Assert.assertTrue(piz.getLibelle().equals(pizzas.get(0).getLibelle()));
		Assert.assertTrue(piz.getCate().equals(pizzas.get(0).getCate()));
	}

	@Test
	public void testPizzaExists() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		ArrayList<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		boolean res = pizzaMemDao.pizzaExists(pizzas.get(0).getCode());
		Assert.assertEquals(res, true);
	}
}
