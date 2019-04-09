package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DAO.PizzaMemDao;
import exception.SavePizzaException;
import model.CategoriePizza;
import model.Pizza;

public class PizzaMemDaoTest {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);

	private PizzaMemDao pizzaMemDao;

	@Rule
	public TestName testName;
	@Rule
	public ExpectedException exE = ExpectedException.none();

	@Before
	public void init() {
		LOG.info("Etant donné une instance de PizzaMemDao."); // revoir là
		pizzaMemDao = new PizzaMemDao();
	}

	@Test
	public void testFindAllPizzas() {
		// exE.expect(NumberFormatException.class);
		// exE.expectMessage("oops");

		LOG.info("Execution de la méthode {}", testName.getMethodName());
		/**
		 * Etant donné | Lorsque ... | Alors ...
		 */
		LOG.info("Lorsqu'on recherche la liste pizza.");
		List<Pizza> list = pizzaMemDao.findAllPizzas();
		LOG.info("Alors la liste de pizza contient au moins une pizza.");
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void test_save_new_pizza_code_diff_3_caractere() {
		LOG.info("Losrque que je sauvegarde une pizza avec un code différent de 3 caractères");
		LOG.info("Alors une exception Sauvegarde");
		exE.expect(SavePizzaException.class);
		exE.expectMessage("oops");
		pizzaMemDao.saveNewPizza(new Pizza(8, "IO", "L'indoienne", 14.00, CategoriePizza.VIANDE));
	}

	@Test
	public void testSaveNewPizza() {
		List<Pizza> listeDePizza = pizzaMemDao.findAllPizzas();
		int tailleInitListe = listeDePizza.size();
		Pizza nouvellePizza = new Pizza(8, "IOD", "L'indoienne", 14.00, CategoriePizza.VIANDE);
		pizzaMemDao.saveNewPizza(nouvellePizza);
		Assert.assertTrue(pizzaMemDao.findAllPizzas().size() == (tailleInitListe + 1));
	}

	@Test
	public void testUpdatePizza() {
		List<Pizza> pizzas = pizzaMemDao.findAllPizzas();
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
		List<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		int tailleInit = pizzas.size();
		Pizza pizza = pizzas.get(0);
		pizzaMemDao.deletePizza(pizza.getCode());
		Assert.assertNotEquals(pizzaMemDao.findAllPizzas().size(), tailleInit);
	}

	@Test
	public void findPizzaByCode() {
		List<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		Pizza piz = pizzaMemDao.findPizzaByCode(pizzas.get(0).getCode());
		Assert.assertTrue(piz.getId() == pizzas.get(0).getId());
		Assert.assertTrue(piz.getCode().equals(pizzas.get(0).getCode()));
		Assert.assertTrue(piz.getPrix() == pizzas.get(0).getPrix());
		Assert.assertTrue(piz.getLibelle().equals(pizzas.get(0).getLibelle()));
		Assert.assertTrue(piz.getCate().equals(pizzas.get(0).getCate()));
	}

	@Test
	public void testPizzaExists() {
		List<Pizza> pizzas = pizzaMemDao.findAllPizzas();
		boolean res = pizzaMemDao.pizzaExists(pizzas.get(0).getCode());
		Assert.assertEquals(res, true);
	}
}
