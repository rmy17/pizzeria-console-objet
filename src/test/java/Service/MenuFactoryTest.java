package Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DAO.PizzaMemDao;

public class MenuFactoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(PizzaMemDao.class);
	private MenuFactory menuFactory;

	@Before
	public void init() {
		LOG.info("Etant donné une instance de MenuFactory."); // revoir là
		menuFactory = new MenuFactory();
	}

	@Test
	public void createTest_pour_lister() {

		MenuService m = menuFactory.create("Lister");
		Assert.assertTrue(m instanceof ListerPizzasService);
	}

	@Test
	public void createTest_pour_ajouter() {

		MenuService m = menuFactory.create("Ajouter");
		Assert.assertTrue(m instanceof AjouterPizzasService);
	}

	@Test
	public void createTest_pour_modifier() {

		MenuService m = menuFactory.create("Modifier");
		Assert.assertTrue(m instanceof ModifierPizzaService);
	}

	@Test
	public void createTest_pour_supprimer() {

		MenuService m = menuFactory.create("Supprimer");
		Assert.assertTrue(m instanceof SupprimerPizzaService);
	}

}
