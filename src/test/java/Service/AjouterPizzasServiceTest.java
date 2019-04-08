package Service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import DAO.IPizzaDao;
import DAO.PizzaMemDao;
import exception.StockageException;
import model.Pizza;

public class AjouterPizzasServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() {
		IPizzaDao dao = new PizzaMemDao();
		systemInMock.provideLines("IOP", "yoplay", "12.00", "SANS_VIANDE");
		List<Pizza> l0 = dao.findAllPizzas();
		int tailleInit = l0.size();
		AjouterPizzasService ajouterPizzasService = new AjouterPizzasService();
		try {
			ajouterPizzasService.executeUC(new Scanner(System.in), dao);
		} catch (StockageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(dao.findAllPizzas().size() == (tailleInit + 1));
	}
}
