package Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import DAO.IPizzaDao;
import exception.StockageException;
import model.CategoriePizza;
import model.Pizza;

public class ModifierPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {
		// Création du mock
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		ListerPizzasService mockedLister = Mockito.mock(ListerPizzasService.class);
		// IPizzaDao dao = new PizzaMemDao();
		Pizza pi = new Pizza("CAN", "Cannibale", 14.00, CategoriePizza.VIANDE);
		Mockito.when(mockedDao.pizzaExists(pi.getCode())).thenReturn(true);

		systemInMock.provideLines("CAN", "IOP", "yoplay", "12.00", "SANS_VIANDE");
		ModifierPizzaService ModifierPizzasService = new ModifierPizzaService();
		ListerPizzasService listerPizzasService = new ListerPizzasService();
		listerPizzasService.executeUC(new Scanner(System.in), mockedDao);
		Mockito.verify(mockedDao).findAllPizzas();
		ModifierPizzasService.setListerPizzaService(listerPizzasService);
		ModifierPizzasService.executeUC(new Scanner(System.in), mockedDao);
		Pizza pizza = new Pizza("IOP", "yoplay", 12.00, CategoriePizza.SANS_VIANDE);
		// Mockito.verify(mockedLister).executeUC(new Scanner(System.in), mockedDao);

		Mockito.verify(mockedDao).updatePizza("CAN", pizza);
		/*
		 * Assert.assertTrue(pi.getLibelle().equals("yoplay"));
		 * Assert.assertTrue(pi.getPrix() == 12.00);
		 * Assert.assertTrue(pi.getCate().equals(CategoriePizza.SANS_VIANDE));
		 */
	}
}
