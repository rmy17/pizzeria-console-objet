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

public class AjouterPizzasServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {
		// Création du mock
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		// IPizzaDao dao = new PizzaMemDao();
		// Etant donné la saisie utilisateur suivante
		systemInMock.provideLines("IOP", "yoplay", "12.00", "SANS_VIANDE");

		// définir comportement du mock
		Pizza pizza = new Pizza("IOP", "yoplay", 12.00, CategoriePizza.SANS_VIANDE);

		// Si le code se passe mal
		// Mockito.doThrow(SavePizzaException.class).when(mockedDao).saveNewPizza(pizza);

		AjouterPizzasService ajouterPizzasService = new AjouterPizzasService();

		ajouterPizzasService.executeUC(new Scanner(System.in), mockedDao);
		// vérifier que la méthode saveNewPizza
		Mockito.verify(mockedDao).saveNewPizza(pizza);
		// Assert.assertTrue(dao.findAllPizzas().size() == (tailleInit + 1));
	}
}
