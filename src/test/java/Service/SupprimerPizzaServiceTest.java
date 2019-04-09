package Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import DAO.IPizzaDao;
import model.CategoriePizza;
import model.Pizza;

public class SupprimerPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() {
		// IPizzaDao dao = new PizzaMemDao();
		// Création du mock
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		systemInMock.provideLines("CAN");
		SupprimerPizzaService supprimerPizzaService = new SupprimerPizzaService();
		Pizza pi = new Pizza("CAN", "Cannibale", 14.00, CategoriePizza.VIANDE);
		Mockito.when(mockedDao.pizzaExists(pi.getCode())).thenReturn(true);
		supprimerPizzaService.executeUC(new Scanner(System.in), mockedDao);
		Mockito.verify(mockedDao).deletePizza(pi.getCode());

	}
}
